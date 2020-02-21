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

import com.digitel.adminvas.webService.adomain.ShortCode;
import com.digitel.adminvas.webService.services.IShortCodeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/shortCode")
public class ShortCodeController {
	
	@Autowired
	private IShortCodeService shortCodeService;
	
	@GetMapping(value = "/readAll")
	public List<ShortCode> index(){
		return shortCodeService.findAll();		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		ShortCode shortCode = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			shortCode = shortCodeService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (shortCode == null) {
			response.put("Mensaje", "El proveedor con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<ShortCode>(shortCode, HttpStatus.OK);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody ShortCode shortCode, @PathVariable Integer id) {
		ShortCode shortCodeBefore = shortCodeService.findById(id);
		ShortCode shortCodeAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (shortCodeBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el numero corto con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			shortCodeBefore.setProductname(shortCode.getProductname());
			shortCodeBefore.setTypeService(shortCode.getTypeService());
			shortCodeBefore.setApproxtraffic(shortCode.getApproxtraffic());
			shortCodeBefore.setDescription(shortCode.getDescription());
			shortCodeBefore.setObservation(shortCode.getObservation());
		
			shortCodeAfter = shortCodeService.save(shortCodeBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("NumeroCorto", shortCodeAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
