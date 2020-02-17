package com.digitel.adminvas.webService.services;

import java.util.List;
import com.digitel.adminvas.webService.adomain.ContentExample;

public interface IContentExampleService {
	
	public List<ContentExample> findAll();
	
	public ContentExample save(ContentExample contentExample);
	
	public ContentExample findById(Integer id);

}
