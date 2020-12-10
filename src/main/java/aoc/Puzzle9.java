package aoc;

import java.util.List;

import aoc.exceptions.UnsolvableException;
import aoc.utils.InputReader;

public class Puzzle9 implements Puzzle<long[]> {
	private static final int PREAMBULE_LENGTH = 25;
	
	@Override
	public long[] getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return lines.stream().mapToLong(Long::parseLong).toArray();
	}

	@Override
	public long resolvePart1(final long[] data) {
		for(int i = PREAMBULE_LENGTH; i < data.length; i++) {
			if(!meetsPreambuleCondition(data, i)) {
				return data[i];
			}
		}
		
		throw new UnsolvableException();
	}

	private boolean meetsPreambuleCondition(final long[] data, final int index) {
		for(int j = index - PREAMBULE_LENGTH; j < index; j++) {
			for(int k = j + 1; k < index; k++) {
				if(data[index] == data[j] + data[k]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public long resolvePart2(long[] data) {
		long verifiedNumber = resolvePart1(data);
		
		for(int i = 0; i < data.length; i++) {
			long sum = 0L;
			long min = Long.MAX_VALUE;
			long max = Long.MIN_VALUE;
			for(int k = i; k < data.length && sum < verifiedNumber; k++) {
				sum += data[k];
				min = Math.min(min, data[k]);
				max = Math.max(max, data[k]);
				
				if(sum == verifiedNumber && k - i > 0) {
					return min + max;
				}
			}
		}
		
		throw new UnsolvableException();
	}
}
