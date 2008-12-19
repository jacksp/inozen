package com.inozen.app.board.support;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CouncelContentValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "socialNumber1", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "socialNumber2", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "celPhoneNumber2", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "celPhoneNumber3", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "이름을 입력하세요");
	}

}
