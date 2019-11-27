package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Impost;


public interface IImpostService {
	
	public List<Impost> findAll();
	
	public void save(Impost impost);

}
