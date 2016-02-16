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

public	class DatabaseInit {
	
	private EntityManager entityManager;

	public DatabaseInit(EntityManager entityManager2) {
		this.entityManager = entityManager2;
	}
	
	public Date getCalendarDate(int y, int m ,int  d){
		GregorianCalendar gcalendar = new GregorianCalendar(y, m, d);
		return gcalendar.getTime();
	}

	public void addDepartments() {
		
		DepartmentEntity entity1 = new DepartmentEntity("Kadr");
		DepartmentEntity entity2 = new DepartmentEntity("Tworzenia");
		DepartmentEntity entity3 = new DepartmentEntity("Rozwoju");
		DepartmentEntity entity4 = new DepartmentEntity("Strategii");
		DepartmentEntity entity5 = new DepartmentEntity("Ogolny");
		
		entityManager.getTransaction().begin();;
		entityManager.persist(entity1);
		entityManager.persist(entity2);
		entityManager.persist(entity3);
		entityManager.persist(entity4);
		entityManager.persist(entity5);
		entityManager.getTransaction().commit();

	}
	
	
	
	public void addWorkers() {
		
		EmploeeEntity entity1 = new EmploeeEntity("Maciej", "Borowik", getCalendarDate(88, 7, 14), "88888888888",null);
		//entity1.setDepartment(department.setId(3));
		EmploeeEntity entity2 = new EmploeeEntity("Agnieszka", "Osińska", getCalendarDate(93,0,12), "77777777777",null);
		//entity1.setDepartment(department.setId(1));
		EmploeeEntity entity3 = new EmploeeEntity("Adam", "Zraju", getCalendarDate(90,0,1), "11111111111",null);
		//entity1.setDepartment(department.setId(2));
		EmploeeEntity entity4 = new EmploeeEntity("Ewa", "Zraju", getCalendarDate(90,0,1), "22222222222",null);
		//entity1.setDepartment(department.setId(2));
		EmploeeEntity entity5 = new EmploeeEntity("Michal", "Chrapczynski", getCalendarDate(87,1,2), "88888888887",null);
		//entity1.setDepartment(department.setId(3));
		EmploeeEntity entity6 = new EmploeeEntity("Mateusz", "Pracik", getCalendarDate(89,7,8), "88888888889",null);
		//entity1.setDepartment(department.setId(4));
		EmploeeEntity entity7 = new EmploeeEntity("Artur", "Lukaszczyk", getCalendarDate(83,2,3), "88888888883",null);
		//entity1.setDepartment(department.setId(3));
		EmploeeEntity entity8 = new EmploeeEntity("Hubert", "Nafalski", getCalendarDate(82,4,5), "88888888882",null);
		//entity1.setDepartment(department.setId(4));
		EmploeeEntity entity9 = new EmploeeEntity("Sywlia", "Mioduszewska", getCalendarDate(86,5,6), "88888888886",null);
		//entity1.setDepartment(department.setId(3));
		EmploeeEntity entity10 = new EmploeeEntity("Anna", "Baran", getCalendarDate(92,6,7), "33333333333",null);
		//entity1.setDepartment(department.setId(3));
		EmploeeEntity entity11 = new EmploeeEntity("Rafal", "Lorenz", getCalendarDate(90,8,9), "44444444444",null);
		//entity1.setDepartment(department.setId(4));
		EmploeeEntity entity12 = new EmploeeEntity("Mala", "Abigeil", getCalendarDate(0,0,0), "00000000000",null);
		//entity1.setDepartment(department.setId(2));
		
		entityManager.getTransaction().begin();
		entityManager.persist(entity1);
		entityManager.persist(entity2);
		entityManager.persist(entity3);
		entityManager.persist(entity4);
		entityManager.persist(entity5);
		entityManager.persist(entity6);
		entityManager.persist(entity7);
		entityManager.persist(entity8);
		entityManager.persist(entity9);
		entityManager.persist(entity10);
		entityManager.persist(entity11);
		entityManager.persist(entity12);
		entityManager.getTransaction().commit();
				
	}
	
	public void addProjects() {
		
		ProjectEntity entity1 = new ProjectEntity("Projekt1",YesNo.N);
		//entity1.setManager("88888888888");
		ProjectEntity entity2 = new ProjectEntity("Projekt2",YesNo.Y);
		//entity1.setManager("11111111111");
		ProjectEntity entity3 = new ProjectEntity("Projekt3",YesNo.N);
		//entity1.setManager("88888888882");
		ProjectEntity entity4 = new ProjectEntity("Projekt4",YesNo.N);
		//entity1.setManager("77777777777");
		ProjectEntity entity5 = new ProjectEntity("Projekt5",YesNo.N);
		//entity1.setManager("22222222222");
		ProjectEntity entity6 = new ProjectEntity("Projekt6",null);
		ProjectEntity entity7 = new ProjectEntity("Projekt7",null,YesNo.Y);
		
		entityManager.getTransaction().begin();;
		entityManager.persist(entity1);
		entityManager.persist(entity2);
		entityManager.persist(entity3);
		entityManager.persist(entity4);
		entityManager.persist(entity5);
		entityManager.persist(entity6);
		entityManager.persist(entity7);
		entityManager.getTransaction().commit();
	
	}
	
	
	public void addWork() {
		
		WorkEntity entity1 = new WorkEntity(null, "Projekt1", getCalendarDate(116,0,4), getCalendarDate(116,0,5), Position.PL, new BigDecimal(5));
		//entity1.setEmploee("88888888888");
		WorkEntity entity2 = new WorkEntity(null, "Projekt2", getCalendarDate(116,0,4), getCalendarDate(116,1,4), Position.TCD, new BigDecimal(10));
		//entity1.setEmploee("88888888888");
		WorkEntity entity3 = new WorkEntity(null, "Projekt2", getCalendarDate(113,1,8), getCalendarDate(116,4,4), Position.TCD, new BigDecimal(10));
		//entity1.setEmploee("77777777777");
		WorkEntity entity4 = new WorkEntity(null, "Projekt3", getCalendarDate(110,0,1), getCalendarDate(115,4,5), Position.TCD, new BigDecimal(9));
		//entity1.setEmploee("22222222222");
		WorkEntity entity5 = new WorkEntity(null, "Projekt4", getCalendarDate(112,7,1), getCalendarDate(114,5,5), Position.PL, new BigDecimal(8));
		//entity1.setEmploee("33333333333");
		WorkEntity entity6 = new WorkEntity(null, "Projekt4", getCalendarDate(100,8,1), getCalendarDate(116,0,1), Position.FCD, new BigDecimal(12));
		//entity1.setEmploee("11111111111");
		WorkEntity entity7 = new WorkEntity(null, "Projekt1", getCalendarDate(115,0,4), getCalendarDate(116,1,1), Position.FCD, new BigDecimal(10));
		//entity1.setEmploee("88888888886");
		WorkEntity entity8 = new WorkEntity(null, "Projekt6", getCalendarDate(105,9,15), getCalendarDate(116,1,8), Position.DEV, new BigDecimal(20));
		//entity1.setEmploee("88888888882");
		WorkEntity entity9 = new WorkEntity(null, "Projekt4", getCalendarDate(104,3,4), getCalendarDate(114,9,14), Position.DEV, new BigDecimal(18));
		//entity1.setEmploee("44444444444");
		WorkEntity entity10 = new WorkEntity(null, "Projekt5", getCalendarDate(115,8,1), getCalendarDate(116,0,2), Position.PL, new BigDecimal(16));
		//entity1.setEmploee("33333333333");
		WorkEntity entity11 = new WorkEntity(null, "Projekt1", getCalendarDate(111,9,1), getCalendarDate(116,0,1), Position.PL, new BigDecimal(10));
		//entity1.setEmploee("88888888887");
		WorkEntity entity12 = new WorkEntity(null, "Projekt1", getCalendarDate(115,7,14), getCalendarDate(116,11,7), Position.DEV, new BigDecimal(16));
		//entity1.setEmploee("88888888889");
		WorkEntity entity13 = new WorkEntity(null, "Projekt3", getCalendarDate(111,1,12), getCalendarDate(115,11,19), Position.TCD, new BigDecimal(20));
		//entity1.setEmploee("88888888886");
		WorkEntity entity14 = new WorkEntity(null, "Projekt2", getCalendarDate(114,6,13), getCalendarDate(115,2,7), Position.PL, new BigDecimal(14));
		//entity1.setEmploee("88888888887");
		WorkEntity entity15 = new WorkEntity(null, "Projekt5", getCalendarDate(114,0,13), getCalendarDate(115,1,17), Position.PL, new BigDecimal(14));
		//entity1.setEmploee("88888888889");
		WorkEntity entity16 = new WorkEntity(null, "Projekt1", getCalendarDate(115,7,4), getCalendarDate(116,1,8), Position.DEV, new BigDecimal(5.5));
		//entity1.setEmploee("88888888883");
		WorkEntity entity17 = new WorkEntity(null, "Projekt2", getCalendarDate(111,8,4), getCalendarDate(115,5,3), Position.PL, new BigDecimal(15));
		//entity1.setEmploee("88888888883");
		WorkEntity entity18 = new WorkEntity(null, "Projekt1", getCalendarDate(114,7,14), getCalendarDate(115,7,14), Position.TCD, new BigDecimal(16));
		//entity1.setEmploee("88888888889");
		WorkEntity entity19 = new WorkEntity(null, "Projekt3", getCalendarDate(114,0,13), null, Position.FCD, new BigDecimal(17));
		//entity1.setEmploee("88888888889");
		WorkEntity entity20 = new WorkEntity(null, "Projekt5", getCalendarDate(114,7,1), null, Position.DEV, new BigDecimal(17));
		//entity1.setEmploee("77777777777");
		WorkEntity entity21 = new WorkEntity(null, "Projekt6", getCalendarDate(114,7,14), null, Position.FCD, new BigDecimal(17));
		//entity1.setEmploee("88888888889");
		
		entityManager.getTransaction().begin();;
		entityManager.persist(entity1);
		entityManager.persist(entity2);
		entityManager.persist(entity3);
		entityManager.persist(entity4);
		entityManager.persist(entity5);
		entityManager.persist(entity6);
		entityManager.persist(entity7);
		entityManager.persist(entity8);
		entityManager.persist(entity9);
		entityManager.persist(entity10);
		entityManager.persist(entity11);
		entityManager.persist(entity12);
		entityManager.persist(entity13);
		entityManager.persist(entity14);
		entityManager.persist(entity15);
		entityManager.persist(entity16);
		entityManager.persist(entity17);
		entityManager.persist(entity18);
		entityManager.persist(entity19);
		entityManager.persist(entity20);
		entityManager.persist(entity21);
		entityManager.getTransaction().commit();
		
	}
	
	
}
