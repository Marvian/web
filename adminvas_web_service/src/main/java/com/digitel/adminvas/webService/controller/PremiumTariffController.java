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


import com.digitel.adminvas.webService.adomain.PremiumTariff;
import com.digitel.adminvas.webService.services.IPremiumTariffService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/premiumTariff")
public class PremiumTariffController {
	
	@Autowired
	private IPremiumTariffService premiumTariffService;
	
	@GetMapping(value = "/readAll")
	public List<PremiumTariff> index(){
		return premiumTariffService.findAll();
		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		PremiumTariff premiumTariff = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			premiumTariff = premiumTariffService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (premiumTariff == null) {
			response.put("Mensaje", "El empleado con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<PremiumTariff>(premiumTariff, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody PremiumTariff premiumTariff) {
		System.out.println(premiumTariff);
		System.out.println("creando nuevo empleado");
		
		PremiumTariff premiumTariffNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			premiumTariffNew = premiumTariffService.save(premiumTariff);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Empleado", premiumTariffNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody PremiumTariff premiumTariff, @PathVariable Integer id) {
		PremiumTariff premiumTariffBefore = premiumTariffService.findById(id);
		PremiumTariff premiumTariffAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (premiumTariffBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			premiumTariffBefore.setType_message(premiumTariff.getType_message());
			premiumTariffBefore.setAmount(premiumTariff.getAmount());
			premiumTariffBefore.setCreateDate(premiumTariff.getCreateDate());
			premiumTariffBefore.setClosingDate(premiumTariff.getClosingDate());
			premiumTariffBefore.setValid(premiumTariff.isValid());
				
			premiumTariffAfter = premiumTariffService.save(premiumTariffBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Traspaso", premiumTariffAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
