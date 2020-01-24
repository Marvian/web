package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.ConfigSistem;
import com.digitel.adminvas.webService.dao.IConfigSistemDao;

@Service
public class ConfigSistemServiceImpl implements IConfigSistemService{

	@Autowired
	private IConfigSistemDao ConfigSistemDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ConfigSistem> findAll() {
		return (List<ConfigSistem>) ConfigSistemDao.findAll();
	}
	
	@Override
	public ConfigSistem findById(Integer id) {
		return ConfigSistemDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ConfigSistem save(ConfigSistem configSistem) {
		return ConfigSistemDao.save(configSistem);
		
	}
	
}
