package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import aoc.Puzzle10;

class Puzzle10Test implements PuzzleTest {
	private static Set<Integer> data;

	@BeforeAll
	public static void setUpBeforeClass(){
		data = new TreeSet<>();
		data.add(28);
		data.add(33);
		data.add(18);
		data.add(42);
		data.add(31);
		data.add(14);
		data.add(46);
		data.add(20);
		data.add(48);
		data.add(47);
		data.add(24);
		data.add(23);
		data.add(49);
		data.add(45);
		data.add(19);
		data.add(38);
		data.add(39);
		data.add(11);
		data.add(1);
		data.add(32);
		data.add(25);
		data.add(35);
		data.add(8);
		data.add(17);
		data.add(7);
		data.add(9);
		data.add(4);
		data.add(2);
		data.add(34);
		data.add(10);
		data.add(3);
	}
	
	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle10 = new Puzzle10();
		assertTrue(puzzle10.resolvePart1(data) == 220);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle10 = new Puzzle10();
		assertTrue(puzzle10.resolvePart2(data) == 19208);
	}
}
