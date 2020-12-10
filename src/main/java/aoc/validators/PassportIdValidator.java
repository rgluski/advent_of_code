package aoc.validators;

import aoc.utils.ValidationUtils;

public class PassportIdValidator implements Validator {

	@Override
	public boolean validate(String field) {
		return ValidationUtils.matchRegexp(field, "^\\d{9}$");
	}

}
