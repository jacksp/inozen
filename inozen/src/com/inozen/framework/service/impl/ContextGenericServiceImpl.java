/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.service.impl;

import com.inozen.framework.data.GenericDao;
import com.inozen.framework.service.ContextGenericService;

/**
 * ContextGenericService imterface implementation.
 * @author seokhoon, seokhoon
 * @param <T> Entity class type
 * @param <D> GenericDao class type
 * @param <P> Searching Paramaters class type(this is just a JavaBean style POJO not any API.)
 * @param <C> Context class type
 */
public class ContextGenericServiceImpl<T,D extends GenericDao<T,P>,P,C> 
 	extends BaseServiceImpl<T,D,P> implements ContextGenericService<T,D,P,C> {

	/**
	 * This class needs daoClass when type-casting on generic methods.
	 * @param persistentClass Entity class type
	 */
	protected ContextGenericServiceImpl(Class<D> persistentClass) {
		super(persistentClass);
	}

	/*
	 * Add like GenericServiceImpl's add().
	 * Apply context is your responsibility.
	 * So when you want to apply context information when adding, 
	 * you have to overriding this methods.
	 * @see com.inozen.framework.service.ContextGenericService#add(java.lang.Object, java.lang.Object)
	 */
	public void add(T entity, C context) {
		dao.add(entity);
		updateAuditWhenAdd(entity);
	}

	/*
	 * Update like GenericServiceImpl's update().
	 * Apply context is your responsibility.
	 * So when you want to apply context information when updating, 
	 * you have to overriding this methods.
	 * @see com.inozen.framework.service.ContextGenericService#update(java.lang.Object, java.lang.Object)
	 */
	public void update(T entity, C context) {
		dao.update(entity);
		updateAuditWhenUpdate(entity);
	}
}
