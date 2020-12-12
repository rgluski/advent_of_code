package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import aoc.Puzzle12;
import aoc.pojo.FerryInstruction;

import static aoc.enums.FerryAction.*;

class Puzzle12Test implements PuzzleTest {
	private static final List<FerryInstruction> DATA = List.of(
			new FerryInstruction(FORWARD, 10),
			new FerryInstruction(NORTH, 3),
			new FerryInstruction(FORWARD, 7),
			new FerryInstruction(RIGHT, 90),
			new FerryInstruction(FORWARD, 11));

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle12 = new Puzzle12();
		assertTrue(puzzle12.resolvePart1(DATA) == 25);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle12 = new Puzzle12();
		assertTrue(puzzle12.resolvePart2(DATA) == 286);
	}
}
