package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.LastPassword;
import com.digitel.adminvas.webService.dao.ILastPasswordDao;

@Service
public class LastPasswordServiceImpl implements ILastPasswordService{

	@Autowired
	private ILastPasswordDao LastPasswordDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<LastPassword> findAll() {
		return (List<LastPassword>) LastPasswordDao.findAll();
	}

	@Override
	public LastPassword findById(Integer id) {
		return LastPasswordDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public LastPassword save(LastPassword lastPassword) {
		return LastPasswordDao.save(lastPassword);
		
	}

}
