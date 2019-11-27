package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.Request;

public interface IRequestDao extends CrudRepository<Request, Integer> {

}
