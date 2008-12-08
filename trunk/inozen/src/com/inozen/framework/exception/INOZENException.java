/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.exception;

/**
 * base class of all INOZEN exception classes.
 * @author seokhoon
 */
public class INOZENException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public INOZENException(Exception e) {
		super(e);
	}

	public INOZENException(String message) {
		super(message);
	}

}
