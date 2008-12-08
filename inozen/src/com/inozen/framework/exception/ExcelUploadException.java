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
 * check if the upload file is excel file that has right header and data.
 * @author seokhoon
 */
public class ExcelUploadException extends INOZENException {

	public ExcelUploadException(Exception e) {
		super(e);
	}

	public ExcelUploadException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
