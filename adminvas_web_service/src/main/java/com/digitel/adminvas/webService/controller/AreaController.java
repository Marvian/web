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

import com.digitel.adminvas.webService.adomain.Area;
import com.digitel.adminvas.webService.services.IAreaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/area")
public class AreaController {
	
	@Autowired
	private IAreaService areaService;
	
	@GetMapping(value = "/readAll")
	public List<Area> index(){
		return areaService.findAll();		
	}
	
	@GetMapping(value = "read/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		
		Area area = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			area = areaService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (area == null) {
			response.put("Mensaje", "El area con ese ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Area>(area, HttpStatus.OK);
	}
	
	@PutMapping(value ="/update/{id}")
	public  ResponseEntity<?> update(@RequestBody Area area, @PathVariable Integer id) {
		Area areaBefore = areaService.findById(id);
		Area areaAfter = null;
		
		Map<String, Object> response = new HashMap<>();
		if (areaBefore == null) {
			response.put("Mensaje", "Error: no se pudo editar el proveedor con el ID ".concat(id.toString()).
					concat(" no existe en la base de dato"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {			
			areaBefore.setEmail(area.getEmail());
			
			areaAfter = areaService.save(areaBefore);
		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la actualización");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "Se realizo la actualización con exito");
		response.put("Area", areaAfter);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;		
	}
	
	

}
