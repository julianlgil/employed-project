package com.employed.employedmanager.service;

import com.employed.employedmanager.dto.EmployedDto;
import com.employed.employedmanager.dto.GetEmployedResponse;
import org.springframework.web.server.MethodNotAllowedException;

import javax.xml.datatype.DatatypeConfigurationException;

public interface EmployedService {

    public GetEmployedResponse getEmployed(EmployedDto employed) throws Exception;
}
