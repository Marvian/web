package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Contract;

public interface IContractService {
	
	public List<Contract> findAll();
	
	public Contract findById(Integer id);
	
	public Contract save(Contract contract);

}
