package aoc.validators;

import aoc.utils.ValidationUtils;

public class ExpirationYearValidator implements Validator {

	@Override
	public boolean validate(String field) {
		return ValidationUtils.validYear(field, 2020, 2030);
	}
}
