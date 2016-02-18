package artur;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PracownikDaoImpl extends AbstractDao2<Pracownik, Long> {
	
	public PracownikDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Pracownik> findByLastName(String name) {
		TypedQuery<Pracownik> query = entityManager.createQuery("select p from Pracownik p where nazwisko=:name", Pracownik.class);
        query.setParameter("name", name);
		return query.getResultList();
	}
	
	public List<Pracownik> findByName(String name) {
		TypedQuery<Pracownik> query = entityManager.createQuery("select p from Pracownik p where nazwa=:name", Pracownik.class);
        query = query.setParameter("name", name);
		return query.getResultList();
	}
	
}
