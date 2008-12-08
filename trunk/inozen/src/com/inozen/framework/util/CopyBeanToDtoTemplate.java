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

/**
 * callback interface used by WebServiceUtils.
 * @author seokhoon
 * @param <S> source type.
 * @param <T> dao type
 * @see com.inozen.framework.util.WebServiceUtils
 */
public interface CopyBeanToDtoTemplate<S,T> {
	public void copy(S source, T dto);
}
