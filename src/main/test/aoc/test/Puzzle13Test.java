package aoc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import aoc.Puzzle13;
import aoc.types.Pair;

public class Puzzle13Test implements PuzzleTest {
	private static final Pair<Integer, List<Integer>> DATA = new Pair<>(939, List.of(7,13,-1,-1,59,-1,31,19));

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle13 = new Puzzle13();
		assertTrue(puzzle13.resolvePart1(DATA) == 295);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle13 = new Puzzle13();
		System.out.println(Long.MAX_VALUE);
		assertTrue(puzzle13.resolvePart2(DATA) == -1);
	}
}
