package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Telephony;
import com.digitel.adminvas.webService.services.ITelephonyService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/telephony")
public class TelephonyController {
	
	@Autowired
	private ITelephonyService telephonyService;
	
	@GetMapping(value = "/readAll")
	public List<Telephony> index(){
		return telephonyService.findAll();
	}

}
