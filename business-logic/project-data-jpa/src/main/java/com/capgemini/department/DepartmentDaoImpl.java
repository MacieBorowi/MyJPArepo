package com.capgemini.department;

import java.sql.ResultSet;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import com.capgemini.dao.AbstractDao;
import com.capgemini.entity.DepartmentEntity;

public class DepartmentDaoImpl extends AbstractDao<DepartmentEntity, Integer> {

	public DepartmentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<DepartmentEntity> findByName(String name) {
		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d where name=:dName", DepartmentEntity.class);
        query.setParameter("dName", name);
		return query.getResultList();
	}
	
	public DepartmentEntity findById(int id) {
		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d where id=:dId", DepartmentEntity.class);
        query.setParameter("dId", id);
        List<DepartmentEntity> result = query.getResultList();
        if(!result.isEmpty()){
        	return result.get(0);
        }
		return null;
	}
	
}