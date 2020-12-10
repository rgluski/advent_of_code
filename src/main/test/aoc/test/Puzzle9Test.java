package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aoc.Puzzle9;

class Puzzle9Test implements PuzzleTest {
	private static final long[] DATA = {1, 2, 13, 14, 15, 6, 7, 3, 25, 10, 16, 17, 18, 4, 5, 11, 12, 8, 9, 22, 23, 24, 19, 20, 21, 26, 49, 99, 50};
	
	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle9 = new Puzzle9();
		assertTrue(puzzle9.resolvePart1(DATA) == 99);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle9 = new Puzzle9();
		assertTrue(puzzle9.resolvePart2(DATA) == 28);
	}
}
