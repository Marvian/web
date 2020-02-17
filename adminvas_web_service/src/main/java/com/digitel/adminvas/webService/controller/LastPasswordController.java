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

import com.digitel.adminvas.webService.adomain.LastPassword;
import com.digitel.adminvas.webService.services.ILastPasswordService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/lastPassword")
public class LastPasswordController {
	
	@Autowired
	private ILastPasswordService lastPasswordService;
	
	@GetMapping(value = "/readAll")
	public List<LastPassword> index(){
		return lastPasswordService.findAll();
		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		LastPassword lastPassword = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			lastPassword = lastPasswordService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (lastPassword == null) {
			response.put("Mensaje", "El proveedor con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<LastPassword>(lastPassword, HttpStatus.OK);
	}
	
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody LastPassword lastPassword, @PathVariable Integer id) {
		LastPassword lastPasswordBefore = lastPasswordService.findById(id);
		LastPassword lastPasswordAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (lastPasswordBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			lastPasswordBefore.setPassword(lastPassword.getPassword());
		
			lastPasswordAfter = lastPasswordService.save(lastPasswordBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Impuesto", lastPasswordAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}
}
