package com.kcomp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.kcomp.model.Base;

@Transactional
public abstract class GenericJpaDao <T, ID extends Serializable> implements GenericDao<T, ID>{
	
	private Class<T> persistentClass;
	private EntityManager entityManager;
	private final static Logger log = Logger.getLogger(GenericJpaDao.class.getName());
	
	public GenericJpaDao(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}
	
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	private EntityTransaction getTransaction(){
		return this.entityManager.getTransaction();
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@Transactional(readOnly=true)
	public T findById(ID id){
		T entity = (T) getEntityManager().find(getPersistentClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> findAll() {
		return getEntityManager()
			.createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
			.getResultList();
	}
	
	public T save(T entity){
		log.info("Saving entity");
		EntityTransaction tx = getTransaction();
		tx.begin();
		this.getEntityManager().persist(entity);
		tx.commit();
		return entity;
	}
	
	public T update(T entity) {
		EntityTransaction tx = getTransaction();
		tx.begin();
		T mergedEntity = getEntityManager().merge(entity);
		tx.commit();
		return mergedEntity;
	}
	
	public void delete(T entity) {
		if (Base.class.isAssignableFrom(persistentClass)) {
			getEntityManager().remove(
					getEntityManager().getReference(entity.getClass(), 
							((Base)entity).getId()));
		} else {
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}
	}
	
	public void flush() {
		getEntityManager().flush();
	}
	
	
}
