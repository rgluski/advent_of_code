package aoc.validators;

import aoc.utils.ValidationUtils;

public class BirthYearValidator implements Validator {

	@Override
	public boolean validate(String field) {
		return ValidationUtils.validYear(field, 1920, 2002);
	}

}
