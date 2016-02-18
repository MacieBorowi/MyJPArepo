package artur;
import javax.persistence.EntityManager;

public class DbInit {
	private EntityManager entityManager;

	public DbInit(EntityManager entityManager2) {
		this.entityManager = entityManager2;
	}
	
	public void addDepartments() {

		Dzial entity1 = new Dzial("Badania i rozwój");
		Dzial entity2 = new Dzial("Finanse");
		Dzial entity3 = new Dzial("Inżynieria");
		Dzial entity4 = new Dzial("IT");
		Dzial entity5 = new Dzial("Logistyka");
		
		entityManager.getTransaction().begin();
		entityManager.persist(entity1);
		entityManager.persist(entity2);
		entityManager.persist(entity3);
		entityManager.persist(entity4);
		entityManager.persist(entity5);
		entityManager.getTransaction().commit();
	}
	
	public void addWorkers() {		
		
		Pracownik entity1 = new Pracownik("Antoni", "Antczak", 70101012345L);
		Pracownik entity2 = new Pracownik("Bożena", "Bartłomik", 74061012345L);
		Pracownik entity3 = new Pracownik("Cezary", "Czubek", 76112112345L);
		Pracownik entity4 = new Pracownik("Dorota", "Dekiel", 78010612345L);
		Pracownik entity5 = new Pracownik("Emil", "Enty", 80121912345L);
		Pracownik entity6 = new Pracownik("Franciszek", "Filc", 81091712345L);
		Pracownik entity7 = new Pracownik("Gustaw", "Gołąbek", 61082212345L);
		Pracownik entity8 = new Pracownik("Helena", "Hiena", 97103012345L);
		Pracownik entity9 = new Pracownik("Ireneusz", "Inżynier", 85071812345L);
		Pracownik entity10 = new Pracownik("Jagoda", "Jerzyk", 70101012379L);
		
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
		entityManager.getTransaction().commit();
	}
	
	public void addProjects() {	
/*		Projekt entity1 = new Projekt("Zarządzanie ruchem gołębi w przestworzach", 70101012345L, IsExternal.nie);
		Projekt entity2 = new Projekt("Przeżycie ofiary w otoczeniu hien", 76112112345L, IsExternal.tak);
		Projekt entity3 = new Projekt("Saruman w świecie Entów", 80121912345L, IsExternal.tak);
		Projekt entity4 = new Projekt("Zwiększenie wydajności superbohaterów", 81091712345L, IsExternal.nie);
		
		entityManager.getTransaction().begin();
		entityManager.persist(entity1);
		entityManager.persist(entity2);
		entityManager.persist(entity3);
		entityManager.persist(entity4);
		entityManager.getTransaction().commit();*/
	}
	
	
}
