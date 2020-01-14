package com.digitel.adminvas.webService.controller;

import java.util.List;

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
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Provider create(@RequestBody Provider provider) {
		System.out.println(provider);
		System.out.println("creando nuevo proveedor");
		return providerService.save(provider);
	}
	
	@PutMapping(value ="/provider/{id}")
	public Provider update(@RequestBody Provider provider, @PathVariable Integer id) {
		Provider providerguardado = providerService.findById(id);
		
		providerguardado.setTypeRif(provider.getTypeRif());
		providerguardado.setRif(provider.getRif());
		providerguardado.setNit(provider.getRif());
		providerguardado.setAddress(provider.getAddress());		
		
			return providerService.save(providerguardado);		
	}
}
