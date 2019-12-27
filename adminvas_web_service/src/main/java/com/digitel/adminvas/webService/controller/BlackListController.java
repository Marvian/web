package com.digitel.adminvas.webService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.BlackList;
import com.digitel.adminvas.webService.services.IBlackListService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/blackList")
public class BlackListController {
	
	@Autowired
	private IBlackListService blackListService;
	
	@GetMapping(value = "/readAll")
	public List<BlackList> index(){
		return blackListService.findAll();
	}

}
