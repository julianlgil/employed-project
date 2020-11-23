package com.employed.employedmanager.controller;

import com.employed.employedmanager.dto.EmployedDto;
import com.employed.employedmanager.dto.GetEmployedResponse;
import com.employed.employedmanager.service.EmployedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.Date;

@RestController
@RequestMapping("/company")
public class EmployedController {

    @Autowired
    private EmployedService employedService;

    @GetMapping("employed")
    public ResponseEntity<GetEmployedResponse> getEmployed(@RequestParam String name,
                                                           @RequestParam String surname,
                                                           @RequestParam String documentType,
                                                           @RequestParam String documentNumber,
                                                           @RequestParam
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthdate,
                                                           @RequestParam
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hiringDate,
                                                           @RequestParam String position,
                                                           @RequestParam Double pay){

        EmployedDto employedDto= new EmployedDto(name, surname, documentType, documentNumber, birthdate, hiringDate, position, pay);
        try {
            GetEmployedResponse response = this.employedService.getEmployed(employedDto);
            return new ResponseEntity<GetEmployedResponse>(response, HttpStatus.OK);
        } catch (DatatypeConfigurationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IllegalAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
