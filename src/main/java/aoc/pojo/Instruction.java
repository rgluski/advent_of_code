package aoc.pojo;

import aoc.enums.Operation;

public class Instruction {
	private final Operation operation;
	private final int argument;
	
	public Instruction(Operation operation2, int argument) {
		this.operation = operation2;
		this.argument = argument;
	}
	
	public Operation getOperation() {
		return operation;
	}
	
	public int getArgument() {
		return argument;
	}
}
