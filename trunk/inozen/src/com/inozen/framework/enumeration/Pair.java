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

/**
 * Make enum entity with this type.
 * @author seokhoon
 * @see @see com.inozen.framework.model.enumeration.UserType
 */
public class Pair {
    int value;
    String descr;

    public Pair() {}
    
    public Pair(int value, String descr) {
		this.value = value;
		this.descr = descr;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescr() {
        return this.descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
}
