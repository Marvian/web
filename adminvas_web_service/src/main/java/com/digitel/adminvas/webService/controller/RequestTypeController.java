package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.RequestType;
import com.digitel.adminvas.webService.services.IRequestTypeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/requestType")
public class RequestTypeController {
	
	@Autowired
	private IRequestTypeService requestTypeService;
	
	@GetMapping(value = "/readAll")
	public List<RequestType> index(){
		return requestTypeService.findAll();
	}

}
