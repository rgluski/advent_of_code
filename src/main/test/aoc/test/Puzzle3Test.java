package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aoc.Puzzle3;

class Puzzle3Test implements PuzzleTest {
	private static final char[][] DATA = {
			{'.','.','#','#','.','.','.','.','.','.','.'},
			{'#','.','.','.','#','.','.','.','#','.','.'},
			{'.','#','.','.','.','.','#','.','.','#','.'},
			{'.','.','#','.','#','.','.','.','#','.','#'},
			{'.','#','.','.','.','#','#','.','.','#','.'},
			{'.','.','#','.','#','#','.','.','.','.','.'},
			{'.','#','.','#','.','#','.','.','.','.','#'},
			{'.','#','.','.','.','.','.','.','.','.','#'},
			{'#','.','#','#','.','.','.','#','.','.','.'},
			{'#','.','.','.','#','#','.','.','.','.','#'},
			{'.','#','.','.','#','.','.','.','#','.','#'}
		};

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle3 = new Puzzle3();
		assertTrue(puzzle3.resolvePart1(DATA) == 7);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle3 = new Puzzle3();
		assertTrue(puzzle3.resolvePart2(DATA) == 336);
	}
}
