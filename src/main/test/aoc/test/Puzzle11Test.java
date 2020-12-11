package aoc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import aoc.Puzzle11;
import aoc.pojo.Seat;

class Puzzle11Test implements PuzzleTest {
	private static final Seat[][] data = {
			{new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L')}, 
			{new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L')}, 
			{new Seat('L'), new Seat('.'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('.'), new Seat('.'), new Seat('L'), new Seat('.'), new Seat('.')}, 
			{new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L')}, 
			{new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L')}, 
			{new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L')}, 
			{new Seat('.'), new Seat('.'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('.'), new Seat('.'), new Seat('.'), new Seat('.'), new Seat('.')}, 
			{new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L')}, 
			{new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L')}, 
			{new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('L'), new Seat('.'), new Seat('L'), new Seat('L')}
	}; 

	@BeforeAll
	public static void setUpBeforeClass() {
		Puzzle11.fillNeighborsForAllSeats(data);
	}
	
	@Test
	@Override
	public void resolvePart1Test() {
		var puzzle11 = new Puzzle11();
		assertTrue(puzzle11.resolvePart1(data) == 37);
	}

	@Test
	@Override
	public void resolvePart2Test() {
		var puzzle11 = new Puzzle11();
		assertTrue(puzzle11.resolvePart2(data) == 26);
	}

}
