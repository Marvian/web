package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.BlackList;
import com.digitel.adminvas.webService.dao.IBlackListDao;

@Service
public class BlackListServiceImpl implements IBlackListService {
	
	@Autowired
	private IBlackListDao BlackListdao;
	
	@Override
	@Transactional(readOnly = true)
	public List<BlackList> findAll() {
		return (List<BlackList>) BlackListdao.findAll();
		
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		BlackListdao.deleteById(id);
		
	}



}
