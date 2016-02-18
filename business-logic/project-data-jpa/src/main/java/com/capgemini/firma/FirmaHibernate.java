package com.capgemini.firma;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.department.DepartmentDaoImpl;
import com.capgemini.emploee.EmploeeDaoImpl;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmploeeEntity;
import com.capgemini.initDB.DatabaseInit;
import com.capgemini.initDB.TestAddObjects;

import artur.Pracownik;
import artur.PracownikDaoImpl;

public class FirmaHibernate {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.myDatabase.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TestAddObjects addTwoObjects = new TestAddObjects(entityManager);
		
		DatabaseInit dbInit = new DatabaseInit(entityManager);
		dbInit.addDepartments();
		dbInit.addProjects();
		dbInit.addWorkers();
		dbInit.addWork();
//		
//		
//	
		
		DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(entityManager);
		List<DepartmentEntity> departments = departmentDao.findByName("Pierwszy");
		System.out.println("Pierwszy");
		for(DepartmentEntity d: departments){
			System.out.println("DEPARTMENT : " + d.getName() + " id =  " + d.getId());
		}
		
		DepartmentEntity finded = departmentDao.findById(9);
		System.out.println("Department by Id : " + finded.getName() + " id =  " + finded.getId());
		
		departments = departmentDao.findAll();
		System.out.println("All : ");
		for(DepartmentEntity d: departments){
			System.out.println("Department : " + d.getName() + " (id " + d.getId() + ")");
		}
		
		System.out.println("");
		DepartmentEntity d = departmentDao.findOne(3);
		System.out.println("Department find one ID 3 : " + d.getName() + " (id " + d.getId() + ")");
		
		EmploeeDaoImpl emploeeDao = new EmploeeDaoImpl(entityManager);
		List<EmploeeEntity> emploees = emploeeDao.findByLastName("Zraju");
		System.out.println("Szukaj Zraju");
		for(EmploeeEntity e: emploees){
			System.out.println("pracownik " + e.getName() + " " + e.getSurname() + " (PESEL "  + e.getPesel() + "), urodzony :" + e.getBornDate().toString());
		}
		if(!emploees.isEmpty()){
		emploeeDao.delete(emploees.get(0));
		}
		List<EmploeeEntity> rajEmploees = emploeeDao.findByLastName("Zraju");
		System.out.println("Szukaj Zraju");
		for(EmploeeEntity e: rajEmploees){
			System.out.println("pracownik " + e.getName() + " " + e.getSurname() + " (PESEL "  + e.getPesel() + "), urodzony :" + e.getBornDate().toString());
		}

		List<EmploeeEntity> allEmploees = entityManager.createNamedQuery("EmploeeEntity.findAllNamedQuery").getResultList();
		
		System.out.println("named Query:  \n");
		for(EmploeeEntity e: allEmploees){
			System.out.println("pracownik " + e.getName() + " " + e.getSurname() + " (PESEL "  + e.getPesel() + "), urodzony :" + e.getBornDate().toString());
		}
		
		
		emploees = emploeeDao.findAlterThen(0);
		
		if(emploees.isEmpty())
		System.out.println("zero");
		
		System.out.println("Szukaj starszych niz");
		for(EmploeeEntity e: emploees){
			System.out.println("pracownik " + e.getName() + " " + e.getSurname() + " (PESEL "  + e.getPesel() + "), urodzony :" + e.getBornDate().toString());
		}
		
	    entityManager.close();
        entityManagerFactory.close();
	}

}
