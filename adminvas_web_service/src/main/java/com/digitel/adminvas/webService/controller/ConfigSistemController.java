package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.ConfigSistem;
import com.digitel.adminvas.webService.services.IConfigSistemService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/ConfigSistem")
public class ConfigSistemController {
	
	@Autowired
	private IConfigSistemService ConfigSistemService;
	
	@GetMapping(value = "/readAll")
	public List<ConfigSistem> index(){
		return ConfigSistemService.findAll();		
	}

}
