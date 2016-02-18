package artur;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	public void main2(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		DbInit dbInit = new DbInit(entityManager);
//		dbInit.addDepartments();
//		dbInit.addWorkers();
//		dbInit.addProjects();
		//TODO dodaj jeszcze Udziały w projektach
		
/*		DzialDaoImpl dzialDao = new DzialDaoImpl(entityManager);
		List<Dzial> dzialy = dzialDao.findByName("Finanse");
		System.out.println("Finanse");
		for(Dzial d: dzialy){
			System.out.println("dział " + d.getNazwa() + " (id " + d.getId() + ")");
		}
		dzialy = dzialDao.findAll();
		System.out.println("All");
		for(Dzial d: dzialy){
			System.out.println("dział " + d.getNazwa() + " (id " + d.getId() + ")");
		}
		Dzial d = dzialDao.findOne(2);
		System.out.println("ID 2: dział " + d.getNazwa() + " (id " + d.getId() + ")");
*/
		PracownikDaoImpl pracownikDao = new PracownikDaoImpl(entityManager);
		List<Pracownik> pracownicy = pracownikDao.findByLastName("Dekiel");
		System.out.println("Dekiel");
		for(Pracownik p: pracownicy){
			System.out.println("pracownik " + p.getNazwa() + " (PESEL " + p.getPESEL() + "), urodzony " + p.getDataUrodzenia().toString());
		}
		pracownicy = pracownikDao.findByLastName("Do");
		System.out.println("Do");
		for(Pracownik p: pracownicy){
			System.out.println("pracownik " + p.getNazwa() + " (PESEL " + p.getPESEL() + "), urodzony " + p.getDataUrodzenia().toString());
		}

		pracownicy = pracownikDao.findByName("Gustaw Gołąbek");
		System.out.println("Gustaw Gołąbek");
		for(Pracownik p: pracownicy){
			System.out.println("pracownik " + p.getNazwa() + " (PESEL " + p.getPESEL() + "), urodzony " + p.getDataUrodzenia().toString());
		}
		pracownicy = pracownikDao.findByName("Dorota Dekiel");
		System.out.println("Dorota Dekiel");
		for(Pracownik p: pracownicy){
			System.out.println("pracownik " + p.getNazwa() + " (PESEL " + p.getPESEL() + "), urodzony " + p.getDataUrodzenia().toString());
		}
		pracownicy = pracownikDao.findByName("Dorota G");
		System.out.println("Dorota G");
		for(Pracownik p: pracownicy){
			System.out.println("pracownik " + p.getNazwa() + " (PESEL " + p.getPESEL() + "), urodzony " + p.getDataUrodzenia().toString());
		}

		
	    entityManager.close();
        entityManagerFactory.close();
	}
}
