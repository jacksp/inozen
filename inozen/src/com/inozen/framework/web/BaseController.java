/**
 * Copyright (c) 2008 Inozen.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.inozen.framework.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.inozen.framework.convention.DefaultConvention;
import com.inozen.framework.data.GenericDao;
import com.inozen.framework.data.support.OrderPage;
import com.inozen.framework.service.BaseService;
import com.inozen.framework.util.ApplicationContextUtils;
import com.inozen.framework.web.support.CommonPages;
import com.inozen.framework.web.support.GenericExcelView;

/**
 * This is Base Generic Controller has generic methods, except add() and update().
 * Subclasses of this controller have to declare 
 * @Contoller annotation and @RequestMapping on class decralation
 * so that the controller can be a annotation based Spring MVC Controller.
 * Notice that this base controller uses "model" session name to reference entity type object.
 * @author seokhoon
 * @author seokhoon
 * @param <T> Entity class type
 * @param <S> BaseService class type
 * @param <R> Reference class type.(This is not an API, but just a simple POJO)
 * @param <V> Validator class type.(This is org.springframework.validation.Validator implementation)
 * @param <P> Searhcing Parameters class type
 * @since 2008.08.01
 * @see com.inozen.framework.controller.GenericController
 * @see com.inozen.framework.controller.ContextGenericController
 */
@SessionAttributes(value="model")
public abstract class BaseController<T,S extends BaseService<T, ? extends GenericDao<T,P>, P>,
				R,V extends Validator,P> implements ApplicationContextAware, InitializingBean {
	protected S service;
	protected R ref;
	protected V validator;

	/** entity class type is used to make modelName and form backing object in subclasses */
	protected Class<T> domainClass;
	protected Class<S> serviceClass;
	protected Class<R> refClass;
	protected Class<V> validatorClass;
	
	/** base url is made by @RequestMapping annotaction's value */
	protected String urlbase;
	
	/** Every searching results can be extract to Excel by this excelView */
	protected AbstractExcelView excelView = new GenericExcelView();
	
	/** Use convention when your package name and class name convention was setup */
	@Autowired(required = false)
	protected DefaultConvention convention;
	
	/** default searching result ordering property is 'id' */
	protected String order = "id desc ";

	protected ApplicationContext applicationContext;
	
	protected BaseController(Class<T> domainClass, Class<S> serviceClass, Class<R> refClass, Class<V> validatorClass) {
		this.domainClass = domainClass;
		this.serviceClass = serviceClass;
		this.refClass = refClass;
		this.validatorClass = validatorClass;
		this.urlbase = retrieveUrlBase();
	}
	
	protected BaseController(Class<T> domainClass, Class<S> serviceClass, Class<R> refClass, Class<V> validatorClass, String order) {
		this(domainClass, serviceClass, refClass, validatorClass);
		this.order = order;
	}
	
	protected String retrieveUrlBase() {
		RequestMapping rm = this.getClass().getAnnotation(RequestMapping.class);
		String url = rm.value()[0];
		String returnString = url.substring(0, url.indexOf("/*"));
		return returnString;
	}
	
	/**
	 * Use this constructor, when you want to set grid order properties and type.
	 * ex) super(entityClass, "name asc age desc");
	 * @param entityClass Entity type
	 * @param order order properties and type(asc, desc)
	 */

	/**
	 * This method give reference data to view
	 * on every request that handled by the controller.
	 * You can reference datas in this object, 
	 * at the result view like this. ${ref.batchList}  
	 * @return reference object type R.
	 */
	@ModelAttribute("ref")
	public R ref() {
		return ref;
	}

	/**
	 * This method handles ${urlbase}/delete.do url.
	 * Delete entity by id.
	 * @param id entity's id.
	 * @return close the popup and re-search grid.
	 * @see com.inozen.framework.web.support.CommonPages#CLOSE_RESEARCH
	 */
	@RequestMapping
	public String delete(int id) {
		// This will not trigger additional query, because the deleting object is already exist in Session Context.
		// We'll use Session's delete(Object) method to apply cascade options.
		service.delete(service.get(id));
		return CommonPages.CLOSE_RESEARCH;
	}
	
	/**
	 * This method handles ${urlbase}/search.do url.
	 * It just showes search.jsp
	 */
	@RequestMapping
	public void search() {
	}
	

	/**
	 * This method handles ${urlbase}/grid.do url.
	 * @param req HttpServletRequest
	 * @param res HttpServletResponse
	 * @param model ModelMap
	 * @param params Searching Parameters object binding by Spring's Default 
	 * PropertyEditors and CustomPropertyEditors that you register
	 * And values are originated form view.
	 * @param orderPage OrderPage
	 * @param view If you request with "excel" as a param value of view, you can get ExcelView. 
	 * ex) base/member/grid.do?view&excel. BUT NOT SUPPORTED NOW.
	 * @return ModelAndView model contains searching result and view name is "grid"
	 * @throws Exception
	 */
	@RequestMapping
	public ModelAndView grid(HttpServletRequest req, HttpServletResponse res, ModelMap model, P params, OrderPage orderPage, String view) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", service.search(params, orderPage));

		ModelAndView returnModelAndView = new ModelAndView(this.urlbase.substring(1) + "/grid", model);
		return returnModelAndView;
	}
	
	@RequestMapping
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res, ModelMap model, P params, OrderPage orderPage, String view) throws Exception {
		if (orderPage.getOrder() == null) {
			orderPage.setOrder(this.order);
		}
		model.addAttribute("orderPage", orderPage);
		model.addAttribute("list", service.search(params, orderPage));

		ModelAndView returnModelAndView = new ModelAndView(this.urlbase.substring(1) + "/list", model);
		return returnModelAndView;
	}

	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		service = (S)ApplicationContextUtils.getBeanByType(applicationContext, serviceClass);
		ref = (R)ApplicationContextUtils.getBeanByType(applicationContext, refClass);
		validator = (V)ApplicationContextUtils.getBeanByType(applicationContext, validatorClass);
		
		if(domainClass == null)
			domainClass = convention.getDomainClassFromController(this.getClass());
	}

	/**
	 * Template method. Use this, when you want to add additional obejct to ModelMap.
	 * @param model ModelMap
	 * @return ModelMap
	 */
	protected ModelMap addReference(ModelMap model) {
		return model;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
