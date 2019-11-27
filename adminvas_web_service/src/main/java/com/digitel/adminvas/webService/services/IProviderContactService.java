package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.ProviderContact;

public interface IProviderContactService {
	
	public List<ProviderContact> findAll();
	
	public void save(ProviderContact providerContact);

}
