package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.ProviderContact;

public interface IProviderContactService {
	
	public List<ProviderContact> findAll();
	
	public ProviderContact findById(Integer id);
	
	public ProviderContact save(ProviderContact providerContact);

}
