package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Privilege;
import com.digitel.adminvas.webService.services.IPrivilegeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {
	
	@Autowired
	private IPrivilegeService PrivilegeService;
	
	@GetMapping(value = "/readAll")
	public List<Privilege> index(){
		return PrivilegeService.findAll();
	}

}
