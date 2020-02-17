package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.RequestType;
import com.digitel.adminvas.webService.dao.IRequestTypeDao;

@Service
public class RequestTypeServiceImpl implements IRequestTypeService{

	@Autowired
	private IRequestTypeDao RequestTypeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RequestType> findAll() {
		return (List<RequestType>) RequestTypeDao.findAll();
	}

	@Override
	public RequestType findById(Integer id) {
		return RequestTypeDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public RequestType save(RequestType requestType) {
		return RequestTypeDao.save(requestType);
		
	}

}
