package com.digitel.adminvas.webService.services;

import com.digitel.adminvas.webService.adomain.Addendum;

public interface IAddendumService {
		
	public Addendum findById(Integer id); 
	
	public Addendum save(Addendum addendum);

}
