package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Log;

public interface ILogService {
	
	public List<Log> findAll();
	
	public Log save(Log log);

}
