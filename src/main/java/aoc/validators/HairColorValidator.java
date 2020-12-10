package aoc.validators;

import aoc.utils.ValidationUtils;

public class HairColorValidator implements Validator {

	@Override
	public boolean validate(String field) {
		return ValidationUtils.matchRegexp(field, "^#[a-f0-9]{6}$");
	}

}
