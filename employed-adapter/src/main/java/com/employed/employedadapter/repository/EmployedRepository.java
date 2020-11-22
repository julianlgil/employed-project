package com.employed.employedadapter.repository;

import com.employed.employedadapter.entity.EmployedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployedRepository extends CrudRepository<EmployedEntity, Integer> {

}
