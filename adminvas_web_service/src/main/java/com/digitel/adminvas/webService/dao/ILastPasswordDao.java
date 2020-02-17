package com.digitel.adminvas.webService.dao;

import org.springframework.data.repository.CrudRepository;

import com.digitel.adminvas.webService.adomain.LastPassword;

public interface ILastPasswordDao extends CrudRepository<LastPassword, Integer> {

}
