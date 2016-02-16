package com.capgemini.firma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.initDB.DatabaseInit;

public class FirmaHibernate {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.myDatabase.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		DatabaseInit dbInit = new DatabaseInit(entityManager);
		dbInit.addDepartments();
		dbInit.addProjects();
		dbInit.addWorkers();
		dbInit.addWork();
		
		
		
		
		
	    entityManager.close();
        entityManagerFactory.close();
	}

}
