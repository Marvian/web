package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.ContracType;
import com.digitel.adminvas.webService.services.IContracTypeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/contracType")
public class ContracTypeController {
	
	@Autowired
	private IContracTypeService contracTypeService;
	
	@GetMapping(value = "/readAll")
	public List<ContracType> index(){
		return contracTypeService.findAll();
	}

}
