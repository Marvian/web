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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.digitel.adminvas.webService.adomain.ProviderContact;
import com.digitel.adminvas.webService.services.IProviderContactService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/ProviderContact")
public class ProviderContactController {
	
	@Autowired
	private IProviderContactService providerContactService;
	
	@GetMapping(value = "/readProviderContact")
	public List<ProviderContact> index(){
		return providerContactService.findAll();
		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		ProviderContact providerContact = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			providerContact = providerContactService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (providerContact == null) {
			response.put("Mensaje", "El contacto de ese empleado con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<ProviderContact>(providerContact, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody ProviderContact providerContact) {
		System.out.println(providerContact);
		System.out.println("creando nuevo empleado");
		
		ProviderContact providerContactNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			providerContactNew = providerContactService.save(providerContact);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Empleado", providerContactNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody ProviderContact providerContact, @PathVariable Integer id) {
		ProviderContact providerContactBefore = providerContactService.findById(id);
		ProviderContact providerContactAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (providerContactBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			providerContactBefore.setName(providerContact.getName());
			providerContactBefore.setLastname(providerContact.getLastname());
			providerContactBefore.setTelephone(providerContact.getTelephone());
			providerContactBefore.setEmail(providerContact.getEmail());
			providerContactBefore.setLevel(providerContact.getLevel());
			providerContactBefore.setPosition(providerContact.getPosition());
			providerContactBefore.setDescription(providerContact.getDescription());
		
		
			providerContactAfter = providerContactService.save(providerContactBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Empleado", providerContactAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
