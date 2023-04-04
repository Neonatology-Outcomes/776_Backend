package com.neonatal.backend.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao {

	public Object saveObject(Object obj) throws Exception;
}
