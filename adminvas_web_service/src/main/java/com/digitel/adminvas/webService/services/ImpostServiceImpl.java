package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Impost;
import com.digitel.adminvas.webService.dao.IImpostDao;

@Service
public class ImpostServiceImpl implements IImpostService{

	@Autowired
	private IImpostDao ImpostDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Impost> findAll() {
		return (List<Impost>) ImpostDao.findAll();
	}

	@Override
	@Transactional
	public void save(Impost impost) {
		ImpostDao.save(impost);
		
	}

}
