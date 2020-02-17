package com.digitel.adminvas.webService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitel.adminvas.webService.adomain.Transfer;
import com.digitel.adminvas.webService.dao.ITransferDao;

@Service
public class TransferServiceImpl implements ITransferService{

	@Autowired
	private ITransferDao TransferDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Transfer> findAll() {
		return (List<Transfer>) TransferDao.findAll();
	}

	@Override
	public Transfer findById(Integer id) {
		return TransferDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Transfer save(Transfer transfer) {
		return TransferDao.save(transfer);
		
	}

}
