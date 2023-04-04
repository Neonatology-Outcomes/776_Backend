package com.neonatal.backend.daoImpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neonatal.backend.config.PersistenceManager;
import com.neonatal.backend.dao.PatientDao;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public Object saveObject(Object obj) throws Exception {
		EntityManager emLocal = PersistenceManager.INSTANCE.getEntityManager();
		try {

			if (!emLocal.getTransaction().isActive()) {
				emLocal.getTransaction().begin();
			}
			obj = emLocal.merge(obj);
			emLocal.getTransaction().commit();
			// @Sourabh Verma added on 10-05-2017
			// to update trigger based fields such as Creationtime/modificationtime
			emLocal.refresh(obj);
			emLocal.clear();
			emLocal.close();
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
			if (emLocal.getTransaction().isActive()) {
				emLocal.getTransaction().rollback();
				emLocal.close();
			}
			throw e;
		}

		finally {
			if (emLocal.isOpen())
				emLocal.close();
		}
	}

}
