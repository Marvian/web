package com.digitel.adminvas.webService.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Addendum;
import com.digitel.adminvas.webService.dao.IAddendumDao;

@Service
public class AddendumServiceImpl implements IAddendumService {

	private IAddendumDao AddendumDao;
	
	@Override
	@Transactional(readOnly = true)
	public Addendum findById(Integer id) {
		return AddendumDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Addendum addendum) {
		AddendumDao.save(addendum);
	
	}

}
