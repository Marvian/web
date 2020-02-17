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

import com.digitel.adminvas.webService.adomain.Interface;
import com.digitel.adminvas.webService.services.IInterfaceService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/interface")
public class InterfaceController {
	
	@Autowired
	private IInterfaceService interfaceService;
	
	@GetMapping(value = "/readAll")
	public List<Interface> index(){
		return interfaceService.findAll();		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Interface Interface = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Interface = interfaceService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (Interface == null) {
			response.put("Mensaje", "La solicitud con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Interface>(Interface, HttpStatus.OK);
	}
		
	
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Interface Interface) {
		System.out.println(Interface);
		System.out.println("creando nueva solicitud");
		
		Interface interfaceNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			interfaceNew = interfaceService.save(Interface);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al insertar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("Mensaje", "Se realizo el insert con exito");
		response.put("Solicitud", interfaceNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody Interface Interface, @PathVariable Integer id) {
		Interface interfaceBefore = interfaceService.findById(id);
		Interface interfaceAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (interfaceBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar la solicitud con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			interfaceBefore.setName(Interface.getName());
		
			interfaceAfter = interfaceService.save(interfaceBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Interface", interfaceAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}

}
