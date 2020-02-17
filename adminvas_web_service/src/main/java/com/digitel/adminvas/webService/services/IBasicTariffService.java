package com.digitel.adminvas.webService.services;

import java.util.List;
import com.digitel.adminvas.webService.adomain.BasicTariff;

public interface IBasicTariffService {
	
	public List<BasicTariff> findAll();
	
	public BasicTariff save(BasicTariff basicTariff);
	
	public BasicTariff findById(Integer id);

}
