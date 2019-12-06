package com.digitel.adminvas.webService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Addendum;
import com.digitel.adminvas.webService.dao.IAddendumDao;

@Service
public class AddendumServiceImpl implements IAddendumService {

	@Autowired
	private IAddendumDao AddendumDao;
		
	
	@Override
	@Transactional(readOnly = true)
	public Addendum findById(Integer id) {
		return AddendumDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Addendum save(Addendum addendum) {
		return AddendumDao.save(addendum);
	
	}

}
