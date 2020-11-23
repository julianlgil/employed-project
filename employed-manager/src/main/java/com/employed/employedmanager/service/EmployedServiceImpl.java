package com.employed.employedmanager.service;

import com.employed.employedmanager.dto.DeltaDateDto;
import com.employed.employedmanager.dto.EmployedDto;
import com.employed.employedmanager.dto.GetEmployedResponse;
import com.employed.employedmanager.soapClient.EmployedSoapClient;
import com.example.consumingwebservice.wsdl.AddEmployedResponse;
import com.example.consumingwebservice.wsdl.Employed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.utilities.Interval;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Service
public class EmployedServiceImpl implements EmployedService{

    private static final Logger log = LoggerFactory.getLogger(EmployedServiceImpl.class);

    @Autowired
    private EmployedSoapClient client;

    @Override
    public GetEmployedResponse getEmployed(EmployedDto employedRequest) throws Exception {
        Employed employedXml = new Employed();
        employedXml.setName(employedRequest.getName());
        employedXml.setSurname(employedRequest.getSurname());
        employedXml.setDocumentType(employedRequest.getDocumentType());
        employedXml.setDocumentNumber(employedRequest.getDocumentNumber());
        employedXml.setBirthdate(employedRequest.getBirthdateXml());
        employedXml.setHiringDate(employedRequest.getHiringDateXml());
        employedXml.setPosition(employedRequest.getPosition());
        employedXml.setPay(employedRequest.getPay());
        AddEmployedResponse result = client.addEmployed(employedXml);
        String statusResponse = result.getStatus();
        log.info("Response from soap service: {}", statusResponse);

        GetEmployedResponse response = new GetEmployedResponse();
        if (statusResponse.equals("Ok")) {
            DeltaDateDto hiringTime = getDeltaDate(employedRequest.getHiringDate());
            DeltaDateDto age = getDeltaDate(employedRequest.getBirthdate());
            response.setAge(age);
            response.setHiringTime(hiringTime);
        } else if (statusResponse.equals("Not allowed")) {
            throw new IllegalAccessException("The employed already exists");
        } else {
            throw new Exception("Server failed");
        }
        return response;
    }

    private DeltaDateDto getDeltaDate(Date oldDate) {
        Date currentDate = new Date();
        LocalDate startDate = convertDateToLocalDate(oldDate);
        LocalDate endDate = convertDateToLocalDate(currentDate);
        Period delta = Period.between(startDate, endDate);
        int years = delta.getYears();
        int months = delta.getMonths();
        int days = delta.getDays();
        log.info("Delta calculated: {} years, {} months, {} days", years, months, days);
        return new DeltaDateDto(years, months, days);
    }

    private LocalDate convertDateToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
