package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aoc.Puzzle1;

class Puzzle1Test implements PuzzleTest {
	private static final int[] DATA = {1721, 979, 366, 299, 675, 1456};

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle1 = new Puzzle1();
		assertTrue(puzzle1.resolvePart1(DATA) == 514579);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle1 = new Puzzle1();
		assertTrue(puzzle1.resolvePart2(DATA) == 241861950);
	}
}
