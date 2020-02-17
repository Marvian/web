package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.MonetaryUnit;
import com.digitel.adminvas.webService.dao.IMonetaryUnitDao;

@Service
public class MonetaryUnitServiceImpl implements IMonetaryUnitService{

	@Autowired
	private IMonetaryUnitDao MonetaryUnitDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<MonetaryUnit> findAll() {
		return (List<MonetaryUnit>) MonetaryUnitDao.findAll();
	}
	
	@Override
	public MonetaryUnit findById(Integer id) {
		return MonetaryUnitDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public MonetaryUnit save(MonetaryUnit monetaryUnit) {
		return MonetaryUnitDao.save(monetaryUnit);
		
	}

}
