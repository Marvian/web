package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Employee;

public interface IEmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(Integer id);
	
	public Employee save(Employee employee);

}
