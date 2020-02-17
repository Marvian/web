package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.PremiumTariff;

public interface IPremiumTariffDao extends CrudRepository<PremiumTariff, Integer> {

}
