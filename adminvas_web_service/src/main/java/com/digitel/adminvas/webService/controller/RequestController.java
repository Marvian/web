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

import com.digitel.adminvas.webService.adomain.Request;
import com.digitel.adminvas.webService.services.IRequestService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/request")
public class RequestController {
	
	@Autowired
	private IRequestService requestService;
	
	@GetMapping(value = "/readAll")
	public List<Request> index(){
		return requestService.findAll();		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Request request = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			request = requestService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (request == null) {
			response.put("Mensaje", "La solicitud con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Request>(request, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Request request) {
		System.out.println(request);
		System.out.println("creando nueva solicitud");
		
		Request requestNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			requestNew = requestService.save(request);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Solicitud", requestNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody Request request, @PathVariable Integer id) {
		Request requestBefore = requestService.findById(id);
		Request requestAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (requestBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar la solicitud con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			requestBefore.setCost(request.getCost());
		
			requestAfter = requestService.save(requestBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Solicitud", requestAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
