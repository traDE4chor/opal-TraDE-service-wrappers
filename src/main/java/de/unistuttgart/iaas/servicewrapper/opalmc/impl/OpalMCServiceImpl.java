/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.unistuttgart.iaas.servicewrapper.opalmc.impl;

import de.uni_stuttgart.iaas.servicewrapper.opalmc.*;
import de.unistuttgart.iaas.servicewrapper.process.ProcessManager;
import de.unistuttgart.iaas.servicewrapper.utils.OpalProperties;
import io.swagger.trade.client.jersey.api.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebService(serviceName = "OpalMCService", endpointInterface = "de.uni_stuttgart.iaas.servicewrapper.opalmc.OpalMC", targetNamespace = "http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/", portName = "OpalMCServicePort", name = "OpalMCServiceImpl")
public class OpalMCServiceImpl implements OpalMC {

    private Logger logger = LoggerFactory.getLogger("de.unistuttgart.iaas.servicewrapper.opalmc.impl.OpalMCServiceImpl");

    private ConcurrentHashMap<String, Integer> _simulationID2PrefixMap;

    private ApiClient _tradeApiClient;

    private ExecutorService _executor;

    public OpalMCServiceImpl() {
        _simulationID2PrefixMap = new ConcurrentHashMap<>();

        _executor = Executors.newCachedThreadPool();

        _tradeApiClient = new ApiClient();
        _tradeApiClient.setBasePath(new OpalProperties().getTraDEUrl());
    }

    public void runOpalMC(TSimulationIdentifier simulationID, String replyToCallbackAddress,
                          TDataModelReference dataModelRef, TDataElementRef opalInput,
                          TDataElementRef opalBccLattice, int numberOfSnapshots, TDataElementRef resultSnapshots,
                          TDataElementRef resultSaturation, TDataElementRef resultReport,
                          Holder<String> simulationIDValue,
                          Holder<Boolean> started, Holder<String> message) {

        // Create a new ProcessManager for the given simulationID
        ProcessManager manager = new ProcessManager(simulationID, _tradeApiClient);
        // Calculate the next available prefix for running the simulation. The prefix is required to avoid file
        // collisions on the underlying OS file system between potentially concurrently running simulations.
        _simulationID2PrefixMap.put(simulationID.getKey(), manager.calcNextPrefix(_simulationID2PrefixMap.values()));

        int prefix = _simulationID2PrefixMap.get(simulationID.getKey());

        try {
            // Prepare the simulation for execution: download input files, create folders, etc.
            manager.prepareProcessExecution(prefix, numberOfSnapshots, dataModelRef, opalInput, opalBccLattice);

            // Run the simulation in a non-blocking way in a separate thread
            Runnable r = () -> {
                try {
                    // Run the simulation
                    manager.startProcess("opalmcimdarg", String.format(ProcessManager.PREFIX_FORMAT, prefix));

                    // Clean up the simulation after execution: upload result files, delete folders, etc.
                    TResultDataList results = manager.postProcessingAndCleanUp(resultSnapshots, resultSaturation,
                            resultReport);

                    // Create a new callback client and trigger the callback
                    OpalMCCallback client = createCallbackClient(replyToCallbackAddress);

                    Callback callback = new Callback();
                    callback.setSimulationIdentifier(simulationID);
                    callback.setResultDataLinks(results);
                    callback.setFaultMessage(null);

                    client.callbackMC(callback);
                } catch (Exception e) {
                    // Create a new callback client and trigger the callback
                    OpalMCCallback client = createCallbackClient(replyToCallbackAddress);

                    Callback callback = new Callback();
                    callback.setSimulationIdentifier(simulationID);
                    callback.setResultDataLinks(null);
                    callback.setFaultMessage(e.getMessage());

                    client.callbackMC(callback);
                } finally {
                    _simulationID2PrefixMap.remove(simulationID.getKey());
                }
            };

            _executor.execute(r);

            started.value = true;
        } catch (Exception e) {
            message.value = e.getMessage();
            started.value = false;

            logger.error("Preparation of service operation execution caused an exception.", e);
        }

        simulationIDValue.value = simulationID.getValue();
    }

    public void prepareOpalMCInputs(TSimulationIdentifier simulationID, String replyToCallbackAddress,
                                    TDataModelReference dataModelRef,
                                    TDataElementRef energyConfiguration, int lx, int ly, int lz,
                                    int numberOfSnapshots, int snapshotFrequency,
                                    int checkpointFrequency, TDataElementRef resultOpalInput, Holder<String>
                                            simulationIDValue, Holder<Boolean>
                                            prepared,
                                    Holder<String> message) {

        // Create a new ProcessManager for the given simulationID
        ProcessManager manager = new ProcessManager(simulationID, _tradeApiClient);
        // Calculate the next available prefix for running the simulation. The prefix is required to avoid file
        // collisions on the underlying OS file system between potentially concurrently running simulations.
        _simulationID2PrefixMap.put(simulationID.getKey(), manager.calcNextPrefix(_simulationID2PrefixMap.values()));

        int prefix = _simulationID2PrefixMap.get(simulationID.getKey());

        try {
            // Prepare the simulation for execution: download input files, create folders, etc.
            manager.prepareProcessExecution(prefix, numberOfSnapshots, dataModelRef, energyConfiguration);

            // Run the simulation in a non-blocking way in a separate thread
            Runnable r = () -> {
                try {
                    // Run the simulation
                    manager.startProcess("./prepareOpalInFile.sh", String.format(ProcessManager.PREFIX_FORMAT,
                            prefix), "econf.dat", lx, ly, lz, numberOfSnapshots, snapshotFrequency, checkpointFrequency);

                    // Clean up the simulation after execution: upload result files, delete folders, etc.
                    TResultDataList results = manager.postProcessingAndCleanUp(resultOpalInput);

                    try {
                        // Create a new callback client and trigger the callback
                        OpalMCPrepareCallback client = createPrepareCallbackClient(replyToCallbackAddress);

                        Callback callback = new Callback();
                        callback.setSimulationIdentifier(simulationID);
                        callback.setResultDataLinks(results);
                        callback.setFaultMessage(null);

                        client.callbackPrepare(callback);
                    } catch (Exception e) {
                        logger.error("Sending the results to the specified callback service caused an " +
                                "exception.", e);
                    }
                } catch (Exception e) {
                    try {
                        // Create a new callback client and trigger the callback
                        OpalMCPrepareCallback client = createPrepareCallbackClient(replyToCallbackAddress);

                        Callback callback = new Callback();
                        callback.setSimulationIdentifier(simulationID);
                        callback.setResultDataLinks(null);
                        callback.setFaultMessage(e.getMessage());

                        client.callbackPrepare(callback);
                    } catch (Exception ex) {
                        logger.error("Sending the results to the specified callback service caused an " +
                                "exception.", ex);
                    }
                } finally {
                    _simulationID2PrefixMap.remove(simulationID.getKey());
                }
            };

            _executor.execute(r);

            prepared.value = true;
        } catch (Exception e) {
            message.value = e.getMessage();
            prepared.value = false;

            logger.error("Preparation of service operation execution caused an exception.", e);
        }

        simulationIDValue.value = simulationID.getValue();
    }

    private OpalMCCallback createCallbackClient(String replyToCallbackAddress) {
        // We need to load the callback WSDL from the classpath
        URL wsdlLocation = null;
        try {
            wsdlLocation =
                    this.getClass().getResource("/opalMC.wsdl");
        } catch (Exception e) {
            logger.error("Loading the opalMC.wsdl from classpath caused an exception.", e);
        }

        // Create the client
        OpalMCCallbackService service = new OpalMCCallbackService(wsdlLocation);
        OpalMCCallback port = service.getOpalMCCallbackServicePort();

        // Change the endpoint address to the provided reply-to address
        BindingProvider bindingProvider = (BindingProvider) port;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, replyToCallbackAddress);

        return port;
    }

    private OpalMCPrepareCallback createPrepareCallbackClient(String replyToCallbackAddress) {
        // We need to load the callback WSDL from the classpath
        URL wsdlLocation = null;
        try {
            wsdlLocation =
                    this.getClass().getResource("/opalMC.wsdl");
        } catch (Exception e) {
            logger.error("Loading the opalMC.wsdl from classpath caused an exception.", e);
        }

        // Create the client
        OpalMCPrepareCallbackService service = new OpalMCPrepareCallbackService(wsdlLocation);
        OpalMCPrepareCallback port = service.getOpalMCPrepareCallbackServicePort();

        // Change the endpoint address to the provided reply-to address
        BindingProvider bindingProvider = (BindingProvider) port;
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, replyToCallbackAddress);

        return port;
    }
}
