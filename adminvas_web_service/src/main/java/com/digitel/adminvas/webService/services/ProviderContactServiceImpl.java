package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.ProviderContact;
import com.digitel.adminvas.webService.dao.IProviderContactDao;

@Service
public class ProviderContactServiceImpl implements IProviderContactService{

	@Autowired
	private IProviderContactDao ProviderContactDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProviderContact> findAll() {
		return (List<ProviderContact>) ProviderContactDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ProviderContact findById(Integer id) {
		return ProviderContactDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ProviderContact save(ProviderContact providerContact) {
		return ProviderContactDao.save(providerContact);
		
	}

}
