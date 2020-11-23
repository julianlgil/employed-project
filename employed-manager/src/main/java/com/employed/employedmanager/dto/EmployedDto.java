package com.employed.employedmanager.dto;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EmployedDto {

    private String name;
    private String surname;
    private String documentType;
    private String documentNumber;
    private Date birthdate;
    private Date hiringDate;
    private String position;
    private Double pay;

    public EmployedDto(String name, String surname, String documentType, String documentNumber,
                       Date birthdate, Date hiringDate, String position, Double pay) {
        this.name = name;
        this.surname = surname;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthdate = birthdate;
        this.hiringDate = hiringDate;
        this.position = position;
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public XMLGregorianCalendar getBirthdateXml() throws DatatypeConfigurationException {
        return getXmlGregorianCalendarFromDate(birthdate);
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public XMLGregorianCalendar getHiringDateXml() throws DatatypeConfigurationException {
        return getXmlGregorianCalendarFromDate(hiringDate);
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }


    public static XMLGregorianCalendar getXmlGregorianCalendarFromDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
}
