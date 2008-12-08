package com.inozen.app.convention;

import com.inozen.framework.convention.DefaultConvention;
import org.springframework.stereotype.Component;

@Component
public class AppConvention extends DefaultConvention {

	public AppConvention() {
		this.domainPackageName = "com.inozen.app.model";
	}
	
}
