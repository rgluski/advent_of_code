package aoc.validators;

import aoc.utils.ValidationUtils;

public class HeightValidator implements Validator {

	@Override
	public boolean validate(String field) {
		return ValidationUtils.validHeight(field, "cm", 3, 150, 193) 
				||  ValidationUtils.validHeight(field, "in", 2, 59, 76);
	}

}
