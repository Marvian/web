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


import com.digitel.adminvas.webService.adomain.BasicTariff;
import com.digitel.adminvas.webService.services.IBasicTariffService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/basicTariff")
public class BasicTariffController {
	
	@Autowired
	private IBasicTariffService basicTariffService;
	
	@GetMapping(value = "/readAll")
	public List<BasicTariff> index(){
		return basicTariffService.findAll();
		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		BasicTariff basicTariff = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			basicTariff = basicTariffService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (basicTariff == null) {
			response.put("Mensaje", "El empleado con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<BasicTariff>(basicTariff, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody BasicTariff basicTariff) {
		System.out.println(basicTariff);
		System.out.println("creando nuevo empleado");
		
		BasicTariff basicTariffNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			basicTariffNew = basicTariffService.save(basicTariff);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Empleado", basicTariffNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody BasicTariff basicTariff, @PathVariable Integer id) {
		BasicTariff basicTariffBefore = basicTariffService.findById(id);
		BasicTariff basicTariffAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (basicTariffBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			basicTariffBefore.setAmount(basicTariff.getAmount());
			basicTariffBefore.setCreateDate(basicTariff.getCreateDate());
			basicTariffBefore.setClosingDate(basicTariff.getClosingDate());
			basicTariffBefore.setValid(basicTariff.isValid());
				
			basicTariffAfter = basicTariffService.save(basicTariffBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Traspaso", basicTariffAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
