package com.mikael0.juddiclient;

/**
 * Created by mikael0 on 09.03.17.
 */

import org.uddi.api_v3.*;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;

/**
 * This shows you to interact with a UDDI server by publishing a Business,
 * Service and Binding Template. It uses code that is specific to the jUDDI
 * client jar's and represents an easier, simpler way to do things. (UDDIClient
 * and UDDIClerk classes). Credentials and URLs are all set via uddi.xml
 */
public class SimplePublish {

    private static UDDIClerk clerk = null;

    public SimplePublish() {
        try {
            // create a client and read the config in the archive;
            // you can use your config file name
            UDDIClient uddiClient = new UDDIClient("META-INF/uddi.xml");
            //get the clerk
            clerk = uddiClient.getClerk("default");
            if (clerk==null)
                throw new Exception("the clerk wasn't found, check the config file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function shows you how to publish to UDDI using a fairly generic
     * mechanism that should be portable (meaning use any UDDI v3 library
     * with this code)
     */
    public void publish(String business, String serviceName, String serviceUrl) {
        try {
            // Creating the parent business entity that will contain our service.
            BusinessEntity myBusEntity = new BusinessEntity();
            Name myBusName = new Name();
            myBusName.setValue(business);
            myBusEntity.getName().add(myBusName);
            // Adding the business entity to the "save" structure, using our publisher's authentication info and saving away.
            BusinessEntity register = clerk.register(myBusEntity);
            if (register == null) {
                System.out.println("Save failed!");
                System.exit(1);
            }
            String myBusKey = register.getBusinessKey();
            System.out.println("myBusiness key:  " + myBusKey);

            // Creating a service to save.  Only adding the minimum data: the parent business key retrieved from saving the business
            // above and a single name.
            BusinessService myService = new BusinessService();
            myService.setBusinessKey(myBusKey);
            Name myServName = new Name();
            myServName.setValue(serviceName);
            myService.getName().add(myServName);

            // Add binding templates, etc...
            BindingTemplate myBindingTemplate = new BindingTemplate();
            AccessPoint accessPoint = new AccessPoint();
            accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
            accessPoint.setValue(serviceUrl);
            myBindingTemplate.setAccessPoint(accessPoint);
            BindingTemplates myBindingTemplates = new BindingTemplates();
            //optional but recommended step, this annotations our binding with all the standard SOAP tModel instance infos
            myBindingTemplate = UDDIClient.addSOAPtModels(myBindingTemplate);
            myBindingTemplates.getBindingTemplate().add(myBindingTemplate);
            myService.setBindingTemplates(myBindingTemplates);
            // Adding the service to the "save" structure, using our publisher's authentication info and saving away.
            BusinessService svc = clerk.register(myService);
            if (svc==null){
                System.out.println("Save failed!");
                System.exit(1);
            }

            String myServKey = svc.getServiceKey();
            System.out.println("myService key:  " + myServKey);

            clerk.discardAuthToken();
            // Now you have a business and service via
            // the jUDDI API!
            System.out.println("Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
