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
	@Transactional(readOnly = true)
	public Contract findById(Integer id) {
		return ContractDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Contract save(Contract contract) {
		return ContractDao.save(contract);
		
	}

}
