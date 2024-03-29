/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.data.support;

import java.util.Arrays;

import com.inozen.framework.enumeration.AbstractType;
import com.inozen.framework.enumeration.Pair;


/**
 * PageSize enum class.
 * This type can't guarantee type-safety.
 * @author seokhoon
 * @see com.inozen.framework.enumeration.AbstractType
 * @see com.inozen.framework.enumeration.Pair
 */
@SuppressWarnings("serial")
public class PageSize  extends AbstractType {
	
	/** This is a thread-safe singleton object */
	private static PageSize saveType = new PageSize();
	
	private PageSize() {
		super(Arrays.asList( 
			new Pair(5, "5"),
			new Pair(10, "10"),
			new Pair(20, "20"),
			new Pair(30, "30"),
			new Pair(50, "50"),
			new Pair(100, "100")
		)); 
	}
	
	/** return thread-safe singleton object */
	public static PageSize getInstance() {
		return saveType;
	}
}

