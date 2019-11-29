package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Area;
import com.digitel.adminvas.webService.services.IAreaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/Area")
public class AreaController {
	
	@Autowired
	private IAreaService AreaService;
	
	@GetMapping(value = "/readAll")
	public List<Area> index(){
		return AreaService.findAll();		
	}

}
