package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Contract;
import com.digitel.adminvas.webService.services.IContractService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/Contract")
public class ContractController {
	
	@Autowired
	private IContractService ContractService;
	
	@GetMapping(value = "/readAll")
	public List<Contract> index(){
		return ContractService.findAll();		
	}

}
