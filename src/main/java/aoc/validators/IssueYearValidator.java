package aoc.validators;

import aoc.utils.ValidationUtils;

public class IssueYearValidator implements Validator {

	@Override
	public boolean validate(String field) {
		return ValidationUtils.validYear(field, 2010, 2020);
	}

}
