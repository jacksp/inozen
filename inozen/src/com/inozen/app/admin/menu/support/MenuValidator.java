package com.inozen.app.admin.menu.support;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author seokhoon
 */
@Component
public class MenuValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "menuName", "required", "입력하세요.");
		ValidationUtils.rejectIfEmpty(errors, "menuType", "required", "선택하세요.");
	}

}
