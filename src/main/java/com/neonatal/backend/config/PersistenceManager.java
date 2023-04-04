package com.neonatal.backend.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
	INSTANCE;

	private EntityManagerFactory emFactory;
	// private EntityManagerFactory emFactoryKalawati;

	private PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory("brandtbc21/neonatal");
	}

	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public void close() {
		emFactory.close();
	}
}