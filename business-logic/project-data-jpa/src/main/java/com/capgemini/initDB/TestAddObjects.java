package com.capgemini.initDB;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmploeeEntity;
import com.capgemini.entity.ProjectEntity;
import com.capgemini.entity.WorkEntity;
import com.capgemini.enums.Position;
import com.capgemini.enums.YesNo;

public class TestAddObjects {
	
	private EntityManager entityManager;

	public TestAddObjects(EntityManager entityManager) {
		this.entityManager = entityManager;
		addObjects();
	}
	
	public Date getCalendarDate(int y, int m ,int  d){
		GregorianCalendar gcalendar = new GregorianCalendar(y, m, d);
		return gcalendar.getTime();
	}

	public void addObjects() {
		
		
		DepartmentEntity department1 = new DepartmentEntity("Pierwszy");
		EmploeeEntity emploee1 = new EmploeeEntity("Pierwszy", "Wpis", getCalendarDate(79, 5, 19), "88888888999",null);
		emploee1.setDepartment(department1);
		ProjectEntity project1 = new ProjectEntity("Projekt0", emploee1, YesNo.Y);
		WorkEntity work1 = new WorkEntity(emploee1, project1, getCalendarDate(99, 6, 1), getCalendarDate(103, 5, 19), Position.FCD , new BigDecimal(22.3));
		
		DepartmentEntity department2 = new DepartmentEntity("Drugi");
		EmploeeEntity emploee2 = new EmploeeEntity("Drugi", "Wpis", getCalendarDate(69, 5, 19), "88888888988",null);
		emploee2.setDepartment(department2);
		ProjectEntity project2 = new ProjectEntity("Projekt99", emploee2, YesNo.N);
		WorkEntity work2 = new WorkEntity(emploee2, project2, getCalendarDate(94, 6, 1), getCalendarDate(101, 5, 19), Position.PL , new BigDecimal(21.3));
		
		entityManager.getTransaction().begin();
		entityManager.persist(department1);
		entityManager.persist(emploee1);
		entityManager.persist(project1);
		entityManager.persist(work1);
		entityManager.persist(department2);
		entityManager.persist(emploee2);
		entityManager.persist(project2);
		entityManager.persist(work2);
		entityManager.getTransaction().commit();
	}
	
}
