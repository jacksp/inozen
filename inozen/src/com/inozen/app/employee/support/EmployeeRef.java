package com.inozen.app.employee.support;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inozen.app.model.enumeration.HobbyType;
import com.inozen.app.model.enumeration.SexType;

/**
 * @author seokhoon
 */
@Component
public class EmployeeRef {

	public SexType getSexType(){
		return SexType.getInstance();
	}

	public HobbyType getHobbyType(){
		return HobbyType.getInstance();
	}
	
	public List<String> getLocations(){
		return Arrays.asList(new String[]{"Korea", "America", "China", "Australia"});
	}
}
