package artur;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao2<T, K extends Serializable> implements Dao2<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;

    private Class<T> domainClass;

	public T save(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
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
		//TODO: poczytać jeszcze o tym, co tu się dzieje
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
        criteriaQuery.from(getDomainClass());
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
	}

	public T update(T entity) {
		T result;
		entityManager.getTransaction().begin();
		result = entityManager.merge(entity);
		entityManager.getTransaction().commit();
        return result;
	}

	public void delete(T entity) {
		entityManager.getTransaction().begin();
        entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	public void delete(K id) {
		entityManager.getTransaction().begin();
        entityManager.remove(getOne(id));
		entityManager.getTransaction().commit();
	}

	public void deleteAll() {
		//TODO: poczytać jeszcze o tym, co tu się dzieje
		entityManager.getTransaction().begin();
        entityManager.createQuery("delete " + getDomainClassName()).executeUpdate();
		entityManager.getTransaction().commit();
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
