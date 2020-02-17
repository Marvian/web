package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.PremiumTariff;

public interface IPremiumTariffService {
	
	public List<PremiumTariff> findAll();
	
	public PremiumTariff save(PremiumTariff premiumTariff);
	
	public PremiumTariff findById(Integer id);

}
