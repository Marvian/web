package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Provider;
import com.digitel.adminvas.webService.services.IProviderService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/provider")
public class ProviderController {
	
	@Autowired
	private IProviderService providerService;
	
	@GetMapping(value = "/readAll")
	public List<Provider> index(){
		return providerService.findAll();
		
	}
	
	@GetMapping(value = "read/{id}")
	public Provider show(@PathVariable Integer id){
		return providerService.findById(id);
	}

}
