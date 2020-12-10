package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import aoc.Puzzle2;
import aoc.pojo.PasswordWithPolicy;

class Puzzle2Test implements PuzzleTest {
	private static final List<PasswordWithPolicy> DATA = List.of(
			new PasswordWithPolicy(1, 3, 'a', "abcde"), 
			new PasswordWithPolicy(1, 3, 'b', "cdefg"), 
			new PasswordWithPolicy(2, 9, 'c', "ccccccccc"));

	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle2 = new Puzzle2();
		assertTrue(puzzle2.resolvePart1(DATA) == 2);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle2 = new Puzzle2();
		assertTrue(puzzle2.resolvePart2(DATA) == 1);
	}
}
