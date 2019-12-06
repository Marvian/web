package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Area;
import com.digitel.adminvas.webService.dao.IAreaDao;

@Service
public class AreaServiceImpl implements IAreaService{

	@Autowired
	private IAreaDao AreaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Area> findAll() {
		return (List<Area>) AreaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Area area) {
		AreaDao.save(area);
		
	}

}
