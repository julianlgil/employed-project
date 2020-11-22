package com.employed.employedadapter.service;

import com.employed.employedadapter.entity.EmployedEntity;
import com.employed.employedadapter.repository.EmployedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployedServiceImpl implements EmployedService{

    @Autowired
    private EmployedRepository repository;

    public EmployedServiceImpl() {
    }

    @Override
    public EmployedEntity addEmployed(EmployedEntity employed){
        return this.repository.save(employed);

    }
}
