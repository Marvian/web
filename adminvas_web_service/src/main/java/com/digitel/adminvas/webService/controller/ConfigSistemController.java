package com.digitel.adminvas.webService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.ConfigSistem;
import com.digitel.adminvas.webService.services.IConfigSistemService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/configSistem")
public class ConfigSistemController {
	
	@Autowired
	private IConfigSistemService configSistemService;
	
	@GetMapping(value = "/readAll")
	public List<ConfigSistem> index(){
		return configSistemService.findAll();		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		ConfigSistem configSistem = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			configSistem = configSistemService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (configSistem == null) {
			response.put("Mensaje", "La configuración con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<ConfigSistem>(configSistem, HttpStatus.OK);
	}
		
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody ConfigSistem configSistem, @PathVariable Integer id) {
		ConfigSistem configSistemBefore = configSistemService.findById(id);
		ConfigSistem configSistemAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (configSistemBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar la configuración con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			configSistemBefore.setEmail_employee(configSistem.getEmail_employee());
			configSistemBefore.setEmail_provider_processed(configSistem.getEmail_provider_processed());
			configSistemBefore.setEmail_provider_date(configSistem.getEmail_provider_date());
			configSistemBefore.setLimit_date(configSistem.getLimit_date());

		
			configSistemAfter = configSistemService.save(configSistemBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Configuración", configSistemAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
