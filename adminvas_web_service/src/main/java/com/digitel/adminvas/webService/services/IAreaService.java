package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Area;


public interface IAreaService {
	
	public List<Area> findAll();
	
	public Area findById(Integer id);
	
	public Area save(Area area);

}
