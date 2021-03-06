package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.ShortCode;
import com.digitel.adminvas.webService.dao.IShortCodeDao;

@Service
public class ShortCodeServiceImpl implements IShortCodeService {

	@Autowired
	private IShortCodeDao shortCodeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ShortCode> findAll() {
		return (List<ShortCode>) shortCodeDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ShortCode findById(Integer id) {
		return shortCodeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ShortCode save(ShortCode shortcode) {
		return shortCodeDao.save(shortcode);
	}

	

}
