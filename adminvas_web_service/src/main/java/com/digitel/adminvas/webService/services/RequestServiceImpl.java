package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Request;
import com.digitel.adminvas.webService.dao.IRequestDao;

@Service
public class RequestServiceImpl implements IRequestService{

	@Autowired
	private IRequestDao RequestDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Request> findAll() {
		return (List<Request>) RequestDao.findAll();
	}

	@Override
	@Transactional
	public Request save(Request request) {
		return RequestDao.save(request);
		
	}

	@Override
	public Request findById(Integer id) {
		return RequestDao.findById(id).orElse(null);
	}

}
