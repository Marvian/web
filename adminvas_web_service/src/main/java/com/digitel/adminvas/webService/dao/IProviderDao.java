package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.Provider;

public interface IProviderDao extends CrudRepository<Provider, Integer> {

}
