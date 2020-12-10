package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import aoc.Puzzle6;

class Puzzle6Test implements PuzzleTest {
	private static final List<List<String>> DATA = List.of(List.of("abc"), 
			List.of("a", "b", "c"),
			List.of("ab", "ac"),
			List.of("a", "a", "a", "a"),
			List.of("b"));

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle6 = new Puzzle6();
		assertTrue(puzzle6.resolvePart1(DATA) == 11);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle6 = new Puzzle6();
		assertTrue(puzzle6.resolvePart2(DATA) == 6);
	}
}
