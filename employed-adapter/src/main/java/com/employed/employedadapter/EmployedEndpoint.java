package com.employed.employedadapter;

import com.employed.employedadapter.entity.EmployedEntity;
import com.employed.employedadapter.service.EmployedService;
import com.javaspringclub.gs_ws.AddEmployedRequest;
import com.javaspringclub.gs_ws.AddEmployedResponse;
import com.javaspringclub.gs_ws.Employed;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployedEndpoint {
    public static final String NAMESPACE_URI = "http://www.testprueba.com/employed";

    @Autowired
    private EmployedService service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployedRequest")
    @ResponsePayload
    public AddEmployedResponse addMovie(@RequestPayload AddEmployedRequest request) {
        AddEmployedResponse response = new AddEmployedResponse();

        EmployedEntity newEmployed = new EmployedEntity(request.getEmployed());
        try {
            EmployedEntity savedEmployedEntity = this.service.addEmployed(newEmployed);
            response.setStatus("Ok");
        } catch (Exception e) {
            response.setStatus("Fail");
        }
        return response;

    }

}
