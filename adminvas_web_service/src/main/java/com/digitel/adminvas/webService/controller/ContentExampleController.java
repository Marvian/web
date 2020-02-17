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

import com.digitel.adminvas.webService.adomain.ContentExample;
import com.digitel.adminvas.webService.services.IContentExampleService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/contentExample")
public class ContentExampleController {
	
	@Autowired
	private IContentExampleService contentExampleService;
	
	@GetMapping(value = "/readAll")
	public List<ContentExample> index(){
		return contentExampleService.findAll();		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		ContentExample contentExample = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			contentExample = contentExampleService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (contentExample == null) {
			response.put("Mensaje", "La solicitud con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<ContentExample>(contentExample, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody ContentExample contentExample) {
		System.out.println(contentExample);
		System.out.println("creando nueva solicitud");
		
		ContentExample contentExampleNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			contentExampleNew = contentExampleService.save(contentExample);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Solicitud", contentExampleNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody ContentExample contentExample, @PathVariable Integer id) {
		ContentExample contentExampleBefore = contentExampleService.findById(id);
		ContentExample contentExampleAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (contentExampleBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar la solicitud con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			contentExampleBefore.setMo_example(contentExample.getMo_example());
			contentExampleBefore.setMt_example(contentExample.getMt_example());
		
			contentExampleAfter = contentExampleService.save(contentExampleBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Solicitud", contentExampleAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
