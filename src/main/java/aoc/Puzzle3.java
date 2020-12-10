package aoc;

import java.util.List;

import aoc.utils.InputReader;

public class Puzzle3 implements Puzzle<char[][]> {
	private static final int RIGHT_STEP = 3;
	private static final int DOWN_STEP = 1;
	private static final int[][] MOVEMENTS = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
	
	@Override
	public char[][] getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);

		var data = new char[lines.size()][];
		
		for(int i = 0; i < lines.size(); i++) {
			data[i] = lines.get(i).toCharArray();
		}
		
		return data;
	}
	
	private long countTrees(char[][] data, int rightStep, int downStep) {
		int rightPos = 0;
		int downPos = 0;
		long treeCount = 0L;
		final int maxDownPos = data.length - 1;
		final int areaWidth = data[0].length;
		
		while(downPos < maxDownPos) {
			rightPos = (rightPos + rightStep) % areaWidth;
			downPos += downStep;
			final char square = data[downPos][rightPos];
			
			if(isTreeSquare(square)) {
				treeCount++;
			}
		}
		
		return treeCount;
	}
	
	@Override
	public long resolvePart1(char[][] data) {
		return countTrees(data, RIGHT_STEP, DOWN_STEP);
	}
	
	@Override
	public long resolvePart2(char[][] data) {
		long multipliedTreesCount = 1L;

		for(int[] movement: MOVEMENTS) {
			multipliedTreesCount *= countTrees(data, movement[0], movement[1]);
		}
		
		return multipliedTreesCount;
	}
	
	private boolean isTreeSquare(char square) {
		return square == '#';
	}
}
