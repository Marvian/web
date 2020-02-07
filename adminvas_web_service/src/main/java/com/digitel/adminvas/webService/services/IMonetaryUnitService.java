package com.digitel.adminvas.webService.services;

import java.util.List;
import com.digitel.adminvas.webService.adomain.MonetaryUnit;

public interface IMonetaryUnitService {
	
	public List<MonetaryUnit> findAll();
	
	public MonetaryUnit save(MonetaryUnit monetaryUnit);
	
	public MonetaryUnit findById(Integer id);

}
