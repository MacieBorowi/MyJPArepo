package com.capgemini.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

//@Transactional
public abstract class AbstractDao<T, K extends Serializable> implements Dao<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;

    private Class<T> domainClass;

	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

//	@SuppressWarnings("unchecked")
	public T getOne(K id) {
        return entityManager.getReference(getDomainClass(), id);
	}

//	@SuppressWarnings("unchecked")
	public T findOne(K id) {
        return entityManager.find(getDomainClass(), id);
	}

//	@SuppressWarnings("unchecked")
	public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
        criteriaQuery.from(getDomainClass());
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
	}

	public T update(T entity) {
        return entityManager.merge(entity);
	}

	public void delete(T entity) {
        entityManager.remove(entity);
	}

	public void delete(K id) {
        entityManager.remove(getOne(id));
	}

	public void deleteAll() {
        entityManager.createQuery("delete " + getDomainClassName()).executeUpdate();
	}

	public long count() {
        return Long.parseLong(entityManager.createQuery("Select count(*) from " + getDomainClassName()).getSingleResult().toString());
	}

	public boolean exists(K id) {
        return findOne(id) != null;
	}
	
    @SuppressWarnings("unchecked")
    protected Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }
    
    protected String getDomainClassName() {
        return getDomainClass().getName();
    }
}
