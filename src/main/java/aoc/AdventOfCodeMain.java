package aoc;

public class AdventOfCodeMain {
	private static final int PUZZLES_DONE = 10;
	
	public static void main(String[] args) throws Exception {
		for(int id = 1; id <= PUZZLES_DONE; id++) {
			String filePath = "data/p" + id + "_input.txt";

			@SuppressWarnings("unchecked")
			var puzzle = (Puzzle<Object>)Class.forName("aoc.Puzzle" + id).getDeclaredConstructor().newInstance();
			var input = puzzle.getInputData(filePath);
			
			System.out.println("Puzzle" + id + " part1 result = " + puzzle.resolvePart1(input));
			System.out.println("Puzzle" + id + " part2 result = " + puzzle.resolvePart2(input));
			System.out.println();
		}
	}
}
