package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.BlackList;

public interface IBlackListDao extends CrudRepository<BlackList, Integer> {

}
