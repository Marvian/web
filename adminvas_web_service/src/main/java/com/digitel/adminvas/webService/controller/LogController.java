package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Log;
import com.digitel.adminvas.webService.services.ILogService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/Area")
public class LogController {
	
	@Autowired
	private ILogService LogService;
	
	@GetMapping(value = "/readAll")
	public List<Log> index(){
		return LogService.findAll();		
	}

}
