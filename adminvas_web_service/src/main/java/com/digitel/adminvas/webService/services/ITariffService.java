package com.digitel.adminvas.webService.services;

import java.util.List;
import com.digitel.adminvas.webService.adomain.Tariff;

public interface ITariffService {
	
	public List<Tariff> findAll();
	
	public Tariff save(Tariff tariff);
	
	public Tariff findById(Integer id);

}
