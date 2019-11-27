package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.Contract;

public interface IContractDao extends CrudRepository<Contract, Integer> {

}
