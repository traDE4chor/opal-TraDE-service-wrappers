# Related information for testing

## Data Model:
- opalData.trade (Create a new DDG at TraDE Middleware and upload the file)
- namespace: http://de.uni-stuttgart.iaas/opalChor
- name: OpalSimulationChoreography

## Preparation
- Create a new DDG resource
- Upload the 'opalData.trade' file to the created DDG resource (POST .../serialized-graph)
- Instantiate the **opalMCInput** data object with correlation properties (need to match with the later service request)
  ``` 
    {
      "createdBy": "hahnml",
      "correlationProperties": [
        {
          "key": "simulationID",
          "value": "testRun"
        }
      ]
    }
  ```
- Resolve the UUIDs of the 'lattice' and 'opal_in' data element instances
  lattice ID: [0beef0e9-fcd6-4e8f-ac48-d9dc555f2052]
  opal_in ID: [131e142e-7500-4683-bb15-9c648ed9577c]
- Create and associate a new data value to each of the data element instances
  - lattice
    - example request: 
      {
        "name": "lattice",
        "createdBy": "hahnml",
        "type": "binary",
        "contentType": "text/plain"
      }
    - lattice data value ID: [bec43fc6-05fb-4186-80f1-262758e4f1db]
  - opal_in
    - example request: 
      {
        "name": "opal_in",
        "createdBy": "hahnml",
        "type": "binary",
        "contentType": "text/plain"
      }
      - opal_in data value ID: [edef0994-3df0-4a5b-8849-6b1c39c99444]
- Upload the binary data to both data values (POST /dataValues/{dataValueId}/data, don't forget to set the 
``X-ResolveAsLinkToData`` header to ``true``) 
through a Dropbox link:
  - lattice: https://www.dropbox.com/s/i61z8qqa1lqqxwk/opalbcc.dat?raw=1
  - opal_in: https://www.dropbox.com/s/0jggzg84k8iy634/opal.in?raw=1
- Try to run the simulation (send example request to opal wrapper service API)

## Example Request:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:opal="http://www.uni-stuttgart.de/iaas/serviceWrapper/opalMC/">
   <soapenv:Header/>
   <soapenv:Body>
      <opal:runOpalMC>
         <simulationIdentifier>
            <key>simulationID</key>
            <value>testRun</value>
         </simulationIdentifier>
         <replyToCallbackAddress>http://localhost:8090/mockOpalCallbackInterfaceSOAP</replyToCallbackAddress>
         <dataModelRef>
            <namespaceURI>http://de.uni-stuttgart.iaas/opalChor</namespaceURI>
            <localName>OpalSimulationChoreography</localName>
         </dataModelRef>
         <opalInput>
            <dataObjectName>opalMCInput</dataObjectName>
            <dataElementName>opal_in</dataElementName>
         </opalInput>
         <opalBccLattice>
            <dataObjectName>opalMCInput</dataObjectName>
            <dataElementName>lattice</dataElementName>
         </opalBccLattice>
         <numberOfSnapshots>10</numberOfSnapshots>
         <resultSnapshots isCollectionDataElement="true">
            <dataObjectName>opalMCOutput</dataObjectName>
            <dataElementName>snapshots[]</dataElementName>
         </resultSnapshots>
         <resultSaturation>
            <dataObjectName>opalMCOutput</dataObjectName>
            <dataElementName>saturation</dataElementName>
         </resultSaturation>
         <resultReport>
            <dataObjectName>opalMCOutput</dataObjectName>
            <dataElementName>report</dataElementName>
         </resultReport>
      </opal:runOpalMC>
   </soapenv:Body>
</soapenv:Envelope>
```

