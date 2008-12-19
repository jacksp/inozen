package com.inozen.app.board.support;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author seokhoon
 */
@Component
public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "required", "입력하세요.");
		ValidationUtils.rejectIfEmpty(errors, "title", "required", "입력하세요.");
		ValidationUtils.rejectIfEmpty(errors, "content", "required", "입력하세요.");
	}

}
