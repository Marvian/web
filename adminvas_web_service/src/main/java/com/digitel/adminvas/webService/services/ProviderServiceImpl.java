package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Provider;
import com.digitel.adminvas.webService.dao.IProviderDao;

@Service
public class ProviderServiceImpl implements IProviderService {

	@Autowired
	private IProviderDao providerDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Provider> findAll() {
		return (List<Provider>) providerDao.findAll();
	}
		
	@Override
	@Transactional(readOnly = true)
	public Provider findById(Integer id) {
		return providerDao.findById(id).orElse(null);
	}

	@Override
	public void save(Provider provider) {
		providerDao.save(provider);
		
	}

}
