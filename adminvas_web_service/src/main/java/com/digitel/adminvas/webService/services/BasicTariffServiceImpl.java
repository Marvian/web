package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.BasicTariff;
import com.digitel.adminvas.webService.dao.IBasicTariffDao;

@Service
public class BasicTariffServiceImpl implements IBasicTariffService{

	@Autowired
	private IBasicTariffDao BasicTariffDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<BasicTariff> findAll() {
		return (List<BasicTariff>) BasicTariffDao.findAll();
	}
	
	@Override
	public BasicTariff findById(Integer id) {
		return BasicTariffDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public BasicTariff save(BasicTariff basicTariff) {
		return BasicTariffDao.save(basicTariff);
		
	}

}
