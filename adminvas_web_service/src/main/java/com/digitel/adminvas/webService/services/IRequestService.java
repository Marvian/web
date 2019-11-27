package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Request;

public interface IRequestService {
	
	public List<Request> findAll();
	
	public void save(Request request);

}
