/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * This style enumeration doesn't support type-safety.
 * @author seokhoon
 * @see com.inozen.framework.model.enumeration.UserType
 */
@SuppressWarnings("serial")
public class AbstractType extends ArrayList<Pair> {
	
	protected boolean throwExceptionIfUnknown = false;
	
	protected AbstractType(List<Pair> list) {
		this(list, false);
	}

	protected AbstractType(List<Pair> list, Boolean throwExceptionIfUnknown) {
		super(list);
		this.throwExceptionIfUnknown = throwExceptionIfUnknown;
	}
	
	public String decode(int value) {
		for(Pair pair : this) {
			if (value == pair.getValue()) return pair.getDescr();
		}
		
		if (throwExceptionIfUnknown)
			throw new IllegalArgumentException("Unknown Value for " + getClass().getSimpleName() + " [" 
					+ value + "]");
		else
			return "UNKNOWN";
	}
}
