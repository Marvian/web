package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Tariff;
import com.digitel.adminvas.webService.dao.ITariffDao;

@Service
public class TariffServiceImpl implements ITariffService{

	@Autowired
	private ITariffDao TariffDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tariff> findAll() {
		return (List<Tariff>) TariffDao.findAll();
	}
	
	@Override
	public Tariff findById(Integer id) {
		return TariffDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Tariff save(Tariff tariff) {
		return TariffDao.save(tariff);
		
	}

}
