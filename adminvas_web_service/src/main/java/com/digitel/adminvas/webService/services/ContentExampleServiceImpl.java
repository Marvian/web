package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.ContentExample;
import com.digitel.adminvas.webService.dao.IContentExampleDao;

@Service
public class ContentExampleServiceImpl implements IContentExampleService{

	@Autowired
	private IContentExampleDao ContentExampleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ContentExample> findAll() {
		return (List<ContentExample>) ContentExampleDao.findAll();
	}
	
	@Override
	public ContentExample findById(Integer id) {
		return ContentExampleDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public ContentExample save(ContentExample contentExample) {
		return ContentExampleDao.save(contentExample);
		
	}

}
