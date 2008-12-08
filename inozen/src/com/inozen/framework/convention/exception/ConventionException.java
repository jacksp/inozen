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
 * ConventionException hierarchy's base class.
 * @author seokhoon
 */
public class ConventionException extends INOZENException {

	private static final long serialVersionUID = -2257786212652868655L;

	public ConventionException(String message) {
		super(message);
	}

	public ConventionException(ClassNotFoundException e) {
		super(e);
	}

}
