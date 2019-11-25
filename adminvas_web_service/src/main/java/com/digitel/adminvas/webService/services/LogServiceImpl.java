package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Log;
import com.digitel.adminvas.webService.dao.ILogDao;

@Service
public class LogServiceImpl implements ILogService{

	@Autowired
	private ILogDao LogDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Log> findAll() {
		return (List<Log>) LogDao.findAll();
	}

	@Override
	@Transactional
	public void save(Log log) {
		LogDao.save(log);
		
	}

}
