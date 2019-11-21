package com.digitel.adminvas.webService.services;
import java.util.List;

import com.digitel.adminvas.webService.adomain.ShortCode;

public interface IShortCodeService {
	
	public List<ShortCode> findAll();
	
	public ShortCode findById(Integer id);
	
	public ShortCode save(ShortCode shortcode);

}
