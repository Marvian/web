package com.digitel.adminvas.webService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.adminvas.webService.adomain.BlackList;
import com.digitel.adminvas.webService.services.IBlackListService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/blackList")
public class BlackListController {
	
	@Autowired
	private IBlackListService blackListService;
	
	@GetMapping(value = "/readAll")
	public List<BlackList> index(){
		return blackListService.findAll();
	}
	
	@DeleteMapping("value = /delete")
	public ResponseEntity<?> detele(@PathVariable int id){

		Map<String, Object> response = new HashMap<>();
		
		try {
		blackListService.delete(id);		
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al eliminar en la base de dato");
			response.put("Error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		response.put("mensaje", "Se elimino con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
