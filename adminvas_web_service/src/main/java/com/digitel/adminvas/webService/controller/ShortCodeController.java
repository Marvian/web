package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.ShortCode;
import com.digitel.adminvas.webService.services.IShortCodeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/shortCode")
public class ShortCodeController {
	
	@Autowired
	private IShortCodeService shortCodeService;
	
	@GetMapping(value = "/readAll")
	public List<ShortCode> index(){
		return shortCodeService.findAll();		
	}
	
	@GetMapping(value = "/read/{id}")
	public ShortCode show(@PathVariable Integer id){
		return shortCodeService.findById(id);
		
	}
	
	

}
