package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Request;
import com.digitel.adminvas.webService.services.IRequestService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/Request")
public class RequestController {
	
	@Autowired
	private IRequestService RequestService;
	
	@GetMapping(value = "/readAll")
	public List<Request> index(){
		return RequestService.findAll();		
	}

}
