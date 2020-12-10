package aoc.test;

import static aoc.enums.Operation.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import aoc.Puzzle8;
import aoc.pojo.Instruction;
class Puzzle8Test implements PuzzleTest {
	private static final Instruction[] DATA = {
			new Instruction(NOP, 0),
			new Instruction(ACC, 1),
			new Instruction(JMP, 4),
			new Instruction(ACC, 3),
			new Instruction(JMP, -3),
			new Instruction(ACC, -99),
			new Instruction(ACC, 1),
			new Instruction(JMP, -4),
			new Instruction(ACC, +6)
	};
	
	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle8 = new Puzzle8();
		assertTrue(puzzle8.resolvePart1(DATA) == 5);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle8 = new Puzzle8();
		assertTrue(puzzle8.resolvePart2(DATA) == 8);
	}
}
