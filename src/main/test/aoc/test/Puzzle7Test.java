package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import aoc.Puzzle7;

class Puzzle7Test implements PuzzleTest {
	private static final Map<String, Map<String, Integer>> DATA_P1 = Map.of(
			"light red", Map.of("bright white", 1, "muted yellow", 2),
			"dark orange", Map.of("bright white", 3, "muted yellow", 4),
			"bright white", Map.of("shiny gold", 1),
			"muted yellow", Map.of("shiny gold", 2, "faded blue", 9),
			"shiny gold", Map.of("dark olive", 1, "vibrant plum", 2),
			"dark olive", Map.of("faded blue", 3, "dotted black", 4),
			"vibrant plum", Map.of("faded blue", 5, "dotted black", 6),
			"faded blue", Map.of(),
			"dotted black", Map.of());

	private static final Map<String, Map<String, Integer>> DATA_P2 = Map.of(
			"shiny gold", Map.of("dark red", 2),
			"dark red", Map.of("dark orange", 2),
			"dark orange", Map.of("dark yellow", 2),
			"dark yellow", Map.of("dark green", 2),
			"dark green", Map.of("dark blue", 2),
			"dark blue", Map.of("dark violet", 2),
			"dark violet", Map.of());
	
	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle7 = new Puzzle7();
		assertTrue(puzzle7.resolvePart1(DATA_P1) == 4);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle7 = new Puzzle7();
		assertTrue(puzzle7.resolvePart2(DATA_P2) == 126);
	}
}
