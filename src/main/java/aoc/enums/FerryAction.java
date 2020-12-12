package aoc.enums;

import java.util.Arrays;

public enum FerryAction {
	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W'),
	LEFT('L'),
	RIGHT('R'),
	FORWARD('F');
	
	private char value;
	
	private FerryAction(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}

	public static FerryAction valueOf(char value){
	    return Arrays.stream(FerryAction.values()).filter(f -> f.getValue() == value)
	    		.findAny().orElseThrow(IllegalArgumentException::new);
	}
}
