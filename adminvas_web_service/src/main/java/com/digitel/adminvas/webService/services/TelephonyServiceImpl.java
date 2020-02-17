package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Telephony;
import com.digitel.adminvas.webService.dao.ITelephonyDao;

@Service
public class TelephonyServiceImpl implements ITelephonyService{

	@Autowired
	private ITelephonyDao TelephonyDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Telephony> findAll() {
		return (List<Telephony>) TelephonyDao.findAll();
	}
	
	@Override
	public Telephony findById(Integer id) {
		return TelephonyDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Telephony save(Telephony telephony) {
		return TelephonyDao.save(telephony);
		
	}

}
