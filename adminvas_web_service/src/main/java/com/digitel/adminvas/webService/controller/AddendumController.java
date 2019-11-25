package com.digitel.adminvas.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.services.IAddendumService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/addendum")
public class AddendumController {
	
	@Autowired
	private IAddendumService addendumService;
	
	

}
