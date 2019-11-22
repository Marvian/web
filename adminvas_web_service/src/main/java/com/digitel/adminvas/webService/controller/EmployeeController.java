package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Employee;
import com.digitel.adminvas.webService.services.IEmployeeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(value = "/readEmployee")
	public List<Employee> index(){
		return employeeService.findAll();
		
	}

}
