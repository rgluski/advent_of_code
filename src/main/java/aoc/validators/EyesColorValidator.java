package aoc.validators;

import java.util.Set;

public class EyesColorValidator implements Validator {
	private static final Set<String> EYES_COLORS = Set.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

	@Override
	public boolean validate(String field) {
		return EYES_COLORS.contains(field);
	}

}
