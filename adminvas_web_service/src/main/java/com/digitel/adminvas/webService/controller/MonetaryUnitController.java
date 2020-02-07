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

import com.digitel.adminvas.webService.adomain.MonetaryUnit;
import com.digitel.adminvas.webService.services.IMonetaryUnitService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/monetaryUnit")
public class MonetaryUnitController {
	
	@Autowired
	private IMonetaryUnitService monetaryUnitService;
	
	@GetMapping(value = "/readAll")
	public List<MonetaryUnit> index(){
		return monetaryUnitService.findAll();
		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		MonetaryUnit monetaryUnit = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			monetaryUnit = monetaryUnitService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (monetaryUnit == null) {
			response.put("Mensaje", "El proveedor con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<MonetaryUnit>(monetaryUnit, HttpStatus.OK);
	}
	
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody MonetaryUnit monetaryUnit, @PathVariable Integer id) {
		MonetaryUnit monetaryUnitBefore = monetaryUnitService.findById(id);
		MonetaryUnit monetaryUnitAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (monetaryUnitBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			monetaryUnitBefore.setName(monetaryUnit.getName());
			monetaryUnitBefore.setNotation(monetaryUnit.getNotation());
		
			monetaryUnitAfter = monetaryUnitService.save(monetaryUnitBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Impuesto", monetaryUnitAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}
}
