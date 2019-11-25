package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Provider;

public interface IProviderService {
	
	public List<Provider> findAll();
	
	public Provider findById(Integer id);
	
	public void save(Provider provider);

}
