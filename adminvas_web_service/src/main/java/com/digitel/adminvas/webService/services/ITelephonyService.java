package com.digitel.adminvas.webService.services;

import java.util.List;
import com.digitel.adminvas.webService.adomain.Telephony;

public interface ITelephonyService {
	
	public List<Telephony> findAll();
	
	public Telephony save(Telephony telephony);
	
	public Telephony findById(Integer id);

}
