/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.data.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.inozen.framework.convention.DefaultConvention;
import com.inozen.framework.data.support.OrderPage;

/**
 * Generic DAO interface implementation with Hibernate. 
 * @author seokhoon, seokhoon
 * @param <T> is Dommain class type. 
 * @param <P> is Search parameter class type.
 * @see com.inozen.framework.data.GenericDao
 * @see com.inozen.framework.convention.DefaultConvention
 * @see org.springframework.beans.factory.InitializingBean
 */
public class HibernateGenericDao<T, P> implements HibernateDao<T, P>, InitializingBean {

	/** Logger available to subclasses */
	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired 
	protected SessionFactory sessionFactory;

	/**
	 * If com.inozen.framework.convention.Convention type is null, 
	 * you must set domain class by constructor HibernateGenericDao(Class<T> clazz)
	 * @see com.inozen.framework.convention.DefaultConvention
	 */
	@Autowired(required = false)
	protected DefaultConvention convention;

	/**
	 * Class for type conversion.
	 */
	protected Class<T> domainClass;

	/**
	 * When use this constructor, you must set Convetion type bean.
	 * @todo example add
	 */
	protected HibernateGenericDao() {
	}

	/**
	 * Use this constuctor when explicitly inject domain class type.
	 * @param domainClass Domain class
	 */
	protected HibernateGenericDao(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	// org.springframework.beans.factory.InitializingBean implementation.

	/**
	 * If persistentClass is null, set persistentClass by convention.
	 * @see com.inozen.framework.convention.DefaultConvention
	 */
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		if (this.domainClass == null && this.convention != null)
			domainClass = (Class<T>) convention.getDomainClassFromDao(this.getClass());
	}

	// com.inozen.framework.data.GenericDao implementation.
	
	public void add(T entity) {
		getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getSession().get(domainClass, id);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteById(Serializable id) {
		getSession().createQuery(
			"delete from " + domainClass.getSimpleName()
			+ " where id = ?").setParameter(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getSession().createQuery(
				"from " + domainClass.getSimpleName()).list();
	}

	public void save(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> search(P params, OrderPage orderPage) {
		
		// rowcount
		orderPage.setRowcount(
			(Integer)(addRestrictions(getSession().createCriteria(this.domainClass), params)
			.setProjection(Projections.rowCount()).uniqueResult()));
		
		Criteria c = 
			addRestrictions(getSession().createCriteria(this.domainClass), params);
		// pages list
		orderPage.applyPage(c);
		orderPage.applyOrder(c);

		return c.list();
	}

	/**
	 * A template method that add Criteria searching conditions,
	 * used by search(P params, OrderPage orderPage)
	 * @todo example code
	 * @see org.hibernate.Criteria
	 */
	protected Criteria addRestrictions(Criteria c, P params) {
		return c;
	}

	// HibernateDao interface implementation.
	
	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public void flushAndClear() {
		flush();
		clear();
	}
	
	public void update(T entity) {
		reattach(entity);
	}
	
	public void reattach(T entity) {
		getSession().update(entity);
	}
	
	public void evict(T entity) {
		getSession().evict(entity);
	}
	
}