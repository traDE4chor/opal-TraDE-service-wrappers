
package de.uni_stuttgart.iaas.servicewrapper.opalmc;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2019-03-27T13:49:03.067+01:00
 * Generated source version: 3.1.12
 * 
 */
public final class OpalMCPrepareCallback_OpalMCPrepareCallbackServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/", "OpalMCPrepareCallbackService");

    private OpalMCPrepareCallback_OpalMCPrepareCallbackServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = OpalMCPrepareCallbackService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        OpalMCPrepareCallbackService ss = new OpalMCPrepareCallbackService(wsdlURL, SERVICE_NAME);
        OpalMCPrepareCallback port = ss.getOpalMCPrepareCallbackServicePort();  
        
        {
        System.out.println("Invoking callbackPrepare...");
        de.uni_stuttgart.iaas.servicewrapper.opalmc.Callback _callbackPrepare_parameters = null;
        port.callbackPrepare(_callbackPrepare_parameters);


        }

        System.exit(0);
    }

}
