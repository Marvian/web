package com.digitel.adminvas.webService.services;

import java.util.List;

import com.digitel.adminvas.webService.adomain.Transfer;


public interface ITransferService {
	
	public List<Transfer> findAll();
	
	public Transfer findById(Integer id);
	
	public Transfer save(Transfer transfer);

}
