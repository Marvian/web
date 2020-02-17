package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.LastPassword;


public interface ILastPasswordService {
	
	public List<LastPassword> findAll();
	
	public LastPassword findById(Integer id);
	
	public LastPassword save(LastPassword lastPassword);

}
