package com.easytable.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.easytable.api.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	

}