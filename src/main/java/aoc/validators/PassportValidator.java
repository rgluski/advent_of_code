package aoc.validators;

import java.util.Map;

public class PassportValidator {

	private static final Map<String, Validator> FIELDS_VALIDATORS = Map.of("byr", new BirthYearValidator(),
																			"iyr", new IssueYearValidator(),
																			"eyr", new ExpirationYearValidator(),
																			"hgt", new HeightValidator(),
																			"hcl", new HairColorValidator(),
																			"ecl", new EyesColorValidator(),
																			"pid", new PassportIdValidator());
	
	public boolean allRequiredFields(Map<String, String> passportFieldsMap) {
		return FIELDS_VALIDATORS.keySet().stream().allMatch(passportFieldsMap::containsKey);
	}
	
	public boolean validateFields(Map<String, String> passportFieldsMap) {
		return passportFieldsMap.entrySet().stream().allMatch(x -> {
			boolean reasult = true;
			Validator validator = FIELDS_VALIDATORS.get(x.getKey());
			if(validator != null) {
				reasult &= validator.validate(x.getValue());
			}
			return reasult;
		});
	}
}
