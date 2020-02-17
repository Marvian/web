package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Interface;


public interface IInterfaceService {
	
	public List<Interface> findAll();
	
	public Interface findById(Integer id);
	
	public Interface save(Interface Interface);

}
