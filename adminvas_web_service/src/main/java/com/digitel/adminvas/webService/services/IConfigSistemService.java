package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.ConfigSistem;

public interface IConfigSistemService {
	
	public List<ConfigSistem> findAll();
	
	public void save(ConfigSistem configSistem);

}
