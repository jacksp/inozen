/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.convention.exception;

import com.inozen.framework.exception.INOZENException;

/**
 * occurs when can't find domain class by convention.
 * @author seokhoon
 */
@SuppressWarnings("serial")
public class CannotLoadDomainClassException extends INOZENException {

	public CannotLoadDomainClassException() {
		super("I can't find domain class");
	}

	public CannotLoadDomainClassException(Exception e) {
		super(e);
	}


}
