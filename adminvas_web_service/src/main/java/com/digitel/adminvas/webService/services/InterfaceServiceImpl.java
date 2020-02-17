package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Interface;
import com.digitel.adminvas.webService.dao.IInterfaceDao;

@Service
public class InterfaceServiceImpl implements IInterfaceService{

	@Autowired
	private IInterfaceDao InterfaceDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Interface> findAll() {
		return (List<Interface>) InterfaceDao.findAll();
	}

	@Override
	public Interface findById(Integer id) {
		return InterfaceDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Interface save(Interface Interface) {
		return InterfaceDao.save(Interface);
		
	}

}
