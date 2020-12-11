package aoc.enums;

import java.util.Arrays;

public enum SeatState {
	FREE('L'), 
	OCCUPIED('#'), 
	NOT_A_SEAT('.');
	
	private char value;
	
	private SeatState(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}
	
	public static SeatState valueOf(char value){
	    return Arrays.stream(SeatState.values()).filter(f -> f.getValue() == value)
	    		.findAny().orElseThrow(IllegalArgumentException::new);
	}
}
