package aoc.pojo;

import aoc.enums.FerryAction;

public class FerryInstruction {
	private FerryAction action;
	private int value;
	
	public FerryInstruction(FerryAction action, int value) {
		this.action = action;
		this.value = value;
	}
	
	public FerryAction getAction() {
		return action;
	}

	public int getValue() {
		return value;
	}
}
