package com.inozen.app.web;

import java.util.Date;

import com.inozen.framework.propertyeditor.FormatDatePropertyEditor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

@Component
public class AppBindingInitializer implements WebBindingInitializer, ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new FormatDatePropertyEditor());
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
