package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.ContracType;
import com.digitel.adminvas.webService.dao.IContracTypeDao;

@Service
public class ContracTypeServiceImpl implements IContracTypeService {
	
	@Autowired
	private IContracTypeDao contracTypedao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ContracType> findAll() {
		return (List<ContracType>) contracTypedao.findAll();
		
	}



}
