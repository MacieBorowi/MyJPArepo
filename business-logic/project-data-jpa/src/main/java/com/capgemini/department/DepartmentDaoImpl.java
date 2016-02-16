package com.capgemini.department;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.capgemini.dao.AbstractDao;
import com.capgemini.entity.DepartmentEntity;

//@Transactional
public class DepartmentDaoImpl extends AbstractDao<DepartmentEntity, Integer> {

	public DepartmentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<DepartmentEntity> findByName(String name) {
		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d where nazwa=:name", DepartmentEntity.class);
        query.setParameter("name", name);
//		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d", DepartmentEntity.class);
		return query.getResultList();
	}
}