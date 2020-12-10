package aoc;

import java.util.List;

import aoc.utils.InputReader;

public class Puzzle1 implements Puzzle<int[]> {

	@Override
	public int[] getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return lines.stream().mapToInt(Integer::parseInt).toArray();
	}
	
	@Override
	public long resolvePart1(int[] data) {
		int result = 0;
		for(int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) {
				if(data[i] + data[j] == 2020) {
					result = data[i] * data[j];
				}
			}
		}
		
		return result;
	}
	
	@Override
	public long resolvePart2(int[] data) {
		int result = 0;
		for(int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) {
				for(int k = j + 1; k < data.length; k++) {
					if(data[i] + data[j] + data[k] == 2020) {
						result = data[i] * data[j] * data[k];
					}
				}
			}
		}
		
		return result;
	}
}