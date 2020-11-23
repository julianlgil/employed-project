package com.employed.employedmanager.soapClient;

import com.example.consumingwebservice.wsdl.AddEmployedRequest;
import com.example.consumingwebservice.wsdl.AddEmployedResponse;
import com.example.consumingwebservice.wsdl.Employed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class EmployedSoapClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(EmployedSoapClient.class);

    public AddEmployedResponse addEmployed(Employed employed) {

        AddEmployedRequest request = new AddEmployedRequest();
        request.setEmployed(employed);

        log.info("Requesting location for employed with info: {}", employed);

        AddEmployedResponse response = (AddEmployedResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/employed", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/addEmployedRequest"));

        return response;
    }
}
