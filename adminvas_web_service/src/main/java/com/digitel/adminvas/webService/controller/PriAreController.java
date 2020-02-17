package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.PriAre;
import com.digitel.adminvas.webService.services.IPriAreService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/PriAre")
public class PriAreController {
	
	@Autowired
	private IPriAreService priAreService;
	
	@GetMapping(value = "/readAll")
	public List<PriAre> index(){
		return priAreService.findAll();
	}

}
