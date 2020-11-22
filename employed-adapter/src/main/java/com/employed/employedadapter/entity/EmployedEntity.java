package com.employed.employedadapter.entity;

import com.javaspringclub.gs_ws.Employed;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employed")
public class EmployedEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "document_number")
    private String documentNumber;
    private Date birthdate;
    @Column(name = "hiring_date")
    private Date hiringDate;
    private String position;
    private Double pay;

    public EmployedEntity() {
    }

    public EmployedEntity(Employed employed) {
        this.name = employed.getName();
        this.surname = employed.getSurname();
        this.documentType = employed.getDocumentType();
        this.documentNumber = employed.getDocumentNumber();
        this.birthdate = employed.getBirthdate().toGregorianCalendar().getTime();
        this.hiringDate = employed.getHiringDate().toGregorianCalendar().getTime();
        this.position = employed.getPosition();
        this.pay = employed.getPay();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiringDate() {
        return hiringDate;
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
}
