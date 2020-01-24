package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Impost;

public interface IImpostService {
	
	public List<Impost> findAll();
	
	public Impost findById(Integer id);
	
	public Impost save(Impost impost);

}
