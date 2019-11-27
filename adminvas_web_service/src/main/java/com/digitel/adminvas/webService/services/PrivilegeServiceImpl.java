package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Privilege;
import com.digitel.adminvas.webService.dao.IPrivilegeDao;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService{

	@Autowired
	private IPrivilegeDao PrivilegeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Privilege> findAll() {
		return (List<Privilege>) PrivilegeDao.findAll();
	}

	@Override
	@Transactional
	public void save(Privilege privilege) {
		PrivilegeDao.save(privilege);
		
	}

}
