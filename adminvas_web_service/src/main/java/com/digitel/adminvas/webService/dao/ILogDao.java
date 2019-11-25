package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.Log;

public interface ILogDao extends CrudRepository<Log, Integer> {

}
