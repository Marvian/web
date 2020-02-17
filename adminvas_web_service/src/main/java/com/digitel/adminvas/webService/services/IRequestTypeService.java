package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.RequestType;


public interface IRequestTypeService {
	
	public List<RequestType> findAll();
	
	public RequestType findById(Integer id);
	
	public RequestType save(RequestType requestType);

}
