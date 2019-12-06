package com.digitel.adminvas.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.Addendum;
import com.digitel.adminvas.webService.services.IAddendumService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/addendum")
public class AddendumController {
	
	@Autowired
	private IAddendumService addendumService;
	
	@GetMapping(value = "/read/{id}")
	public Addendum show(@PathVariable Integer id){
		return addendumService.findById(id);
	}
		
	@PostMapping(value = "/addendum/")
	@ResponseStatus(HttpStatus.CREATED)
	public Addendum create(@RequestBody Addendum addendum) {
		return addendumService.save(addendum);
	}
	
	@PutMapping(value ="/addendum/{id}")
	public Addendum update(@RequestBody Addendum addendum, @PathVariable Integer id) {
		Addendum addendumguardado = addendumService.findById(id);
		
		addendumguardado.setDescription(addendum.getDescription());
		addendumguardado.setPercent(addendum.getPercent());
		addendumguardado.setType(addendum.getType());
		addendumguardado.setMTXMO(addendum.getMTXMO());
		
			return addendumService.save(addendumguardado);
	}

}
