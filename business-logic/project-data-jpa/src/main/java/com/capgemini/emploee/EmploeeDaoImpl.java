package com.capgemini.emploee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.dao.AbstractDao;
import com.capgemini.entity.EmploeeEntity;

public class EmploeeDaoImpl extends AbstractDao<EmploeeEntity, Long> {

	public EmploeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<EmploeeEntity> findByLastName(String name) {
		TypedQuery<EmploeeEntity> query = entityManager.createQuery("select p from EmploeeEntity p where surname=:name",
				EmploeeEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	public List<EmploeeEntity> findByName(String name) {
		TypedQuery<EmploeeEntity> query = entityManager.createQuery("select p from EmploeeEntity p where nazwa=:name",
				EmploeeEntity.class);
		query = query.setParameter("name", name);
		return query.getResultList();
	}

	public List<EmploeeEntity> findByNameNQ() {
		Query query = entityManager.createQuery("EmploeeEntity.findAllNamedQuery");
		return query.getResultList();
	}
	
	public List<EmploeeEntity> findAlterThen(int i) {
		TypedQuery<EmploeeEntity> query = entityManager.createQuery("select p from EmploeeEntity p where YEAR(CURRENT_DATE) - YEAR(bornDate) >:alt",
				EmploeeEntity.class);
		query = query.setParameter("alt", i);
		return query.getResultList();
	}
	
}
