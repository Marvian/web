package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.PremiumTariff;
import com.digitel.adminvas.webService.dao.IPremiumTariffDao;

@Service
public class PremiumTariffServiceImpl implements IPremiumTariffService{

	@Autowired
	private IPremiumTariffDao PremiumTariffDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PremiumTariff> findAll() {
		return (List<PremiumTariff>) PremiumTariffDao.findAll();
	}

	@Override
	@Transactional
	public PremiumTariff save(PremiumTariff premiumTariff) {
		return PremiumTariffDao.save(premiumTariff);
		
	}

	@Override
	public PremiumTariff findById(Integer id) {
		return PremiumTariffDao.findById(id).orElse(null);
	}

}
