package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Contract;

public interface IContractService {
	
	public List<Contract> findAll();
	
	public void save(Contract contract);

}
