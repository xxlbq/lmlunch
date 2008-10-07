package com.livedoor.flow_manager.user.interfaces;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericHibernateDao<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, ID> {

	private Class persistentClass;

	public GenericHibernateDao() {
		this.persistentClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		T entity;

		entity = (T) getHibernateTemplate().load(getPersistentClass(), id);

		return entity;
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		return getHibernateTemplate().loadAll(getPersistentClass());
	}

	@SuppressWarnings("unchecked")
	public List findByExample(T exampleInstance) {

		return findByCriteria(Example.create(exampleInstance));
	}

	@SuppressWarnings("unchecked")
	public T makePersistent(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List findByCriteria(Criterion... criterion) {

		DetachedCriteria crit = DetachedCriteria.forClass(getPersistentClass());

		for (Criterion c : criterion) {
			crit.add(c);
		}

		return getHibernateTemplate().findByCriteria(crit);
	}

}
