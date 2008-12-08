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

import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 * callback interface when uploads exel file.
 * @author seokhoon
 */
public interface ExcelUploadTemplate {

	/**
	 * Validate excel by row's columns
	 * @param row
	 * @return If row validate passes, return true. 
	 */
	boolean checkColumnHeader(HSSFRow row);
	
	/**
	 * Make entity in this template by parameters.
	 * @param row takes each row in sheet.
	 * @param values if you need more infomation except excel, then you can use this parameter.
	 */
	void makeEntity(HSSFRow row, Map<String, Object> values);

}
