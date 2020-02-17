package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.PriAre;
import com.digitel.adminvas.webService.dao.IPriAreDao;

@Service
public class PriAreServiceImpl implements IPriAreService {
	
	@Autowired
	private IPriAreDao PriAredao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PriAre> findAll() {
		return (List<PriAre>) PriAredao.findAll();
		
	}



}
