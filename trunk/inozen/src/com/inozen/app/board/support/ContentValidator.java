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
		ValidationUtils.rejectIfEmpty(errors, "name", "required", "�Է��ϼ���.");
		ValidationUtils.rejectIfEmpty(errors, "title", "required", "�Է��ϼ���.");
		ValidationUtils.rejectIfEmpty(errors, "content", "required", "�Է��ϼ���.");
	}

}
