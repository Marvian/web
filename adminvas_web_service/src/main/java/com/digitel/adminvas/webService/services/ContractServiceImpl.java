package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Contract;
import com.digitel.adminvas.webService.dao.IContractDao;


@Service
public class ContractServiceImpl implements IContractService{

	@Autowired
	private IContractDao ContractDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contract> findAll() {
		return (List<Contract>) ContractDao.findAll();
	}

	@Override
	@Transactional
	public void save(Contract contract) {
		ContractDao.save(contract);
		
	}

}
