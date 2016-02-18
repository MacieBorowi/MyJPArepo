package artur;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DzialDaoImpl extends AbstractDao2<Dzial, Integer> {

	public DzialDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Dzial> findByName(String name) {
		TypedQuery<Dzial> query = entityManager.createQuery("select d from Dzial d where nazwa=:name", Dzial.class);
        query.setParameter("name", name);
		return query.getResultList();
	}
}