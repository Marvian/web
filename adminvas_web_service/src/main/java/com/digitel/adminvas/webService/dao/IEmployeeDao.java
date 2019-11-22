package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.Employee;

public interface IEmployeeDao extends CrudRepository<Employee, Integer> {

}
