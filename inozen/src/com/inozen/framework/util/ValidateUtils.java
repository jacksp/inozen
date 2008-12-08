/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.util;

import org.springframework.validation.Errors;

/**
 * Validation util class.
 * @author seokhoon
 */
public class ValidateUtils {

	public static void rejectIfConditionFalse(Boolean confition,
			Errors errors, String fieldName, String errorCode,
			String defaultMessage) {
		
		if (confition)
			errors.rejectValue(fieldName, errorCode, defaultMessage);
	}

	public static void rejectIfNullOrZero(Integer value, Errors errors, String fieldName,
			String errorCode, String defaultMessage) {
		
		if(value == null || value == 0)
			errors.rejectValue(fieldName, errorCode, defaultMessage);

	}

}
