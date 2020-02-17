package com.digitel.adminvas.webService.controller;

import java.util.HashMap;
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

import com.digitel.adminvas.webService.adomain.Addendum;
import com.digitel.adminvas.webService.services.IAddendumService;

@CrossOrigin(origins = {"http://localhost:4210"})
@RestController
@RequestMapping(value = "/addendum")
public class AddendumController {
	
	@Autowired
	private IAddendumService addendumService;
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Addendum addendum = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			addendum = addendumService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (addendum == null) {
			response.put("Mensaje", "El proveedor con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Addendum>(addendum, HttpStatus.OK);
	}
		
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Addendum addendum) {
		System.out.println(addendum);
		System.out.println("creando nuevo Addendum");
		
		Addendum addendumNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			addendumNew = addendumService.save(addendum);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Addedum", addendumNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody Addendum addendum, @PathVariable Integer id) {
		Addendum addendumBefore = addendumService.findById(id);
		Addendum addendumAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (addendumBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			addendumBefore.setDescription(addendum.getDescription());
			addendumBefore.setPercent(addendum.getPercent());
			addendumBefore.setType(addendum.getType());
			addendumBefore.setMTXMO(addendum.getMTXMO());
		
			addendumAfter = addendumService.save(addendumBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Addedum", addendumAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
