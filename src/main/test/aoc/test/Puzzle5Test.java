package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import aoc.Puzzle5;

class Puzzle5Test implements PuzzleTest {
	private static final List<String> DATA = List.of("FBFBBFFRLR", "FBFBBFFRRR");

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle5 = new Puzzle5();
		assertTrue(puzzle5.resolvePart1(DATA) == 359);
	}
	
	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle5 = new Puzzle5();
		assertTrue(puzzle5.resolvePart2(DATA) == 358);
	}
}
