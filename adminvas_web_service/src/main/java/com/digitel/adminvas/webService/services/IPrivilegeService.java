package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Privilege;

public interface IPrivilegeService {
	
	public List<Privilege> findAll();
	
	public void save(Privilege privilege);

}
