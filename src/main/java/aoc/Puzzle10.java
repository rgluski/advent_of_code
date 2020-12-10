package aoc;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import aoc.exceptions.UnsolvableException;
import aoc.utils.InputReader;

public class Puzzle10 implements Puzzle<Set<Integer>> {

	@Override
	public Set<Integer> getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return lines.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(TreeSet::new));
	}

	@Override
	public long resolvePart1(Set<Integer> data) {
		//all counters set to 0 except counter[3], because there is always one final adapter with difference 3 to connect mobile phone
		int[] counter = {0, 0, 0, 1};
		
		data.stream().reduce(0, (a, b) -> {
			int diff = b - a;
			if(diff > 3) {
				throw new UnsolvableException();
			}
			counter[diff]++;

			return b;
		});
		
		return (long)counter[1] * counter[3];
	}

	@Override
	public long resolvePart2(Set<Integer> data) {
		final int max = data.stream().mapToInt(Integer::intValue).max().getAsInt();
		
		//we have array with zeroes from 0 to max number in the adapters set
		long[] counterArray = new long[max + 1];
		
		//combination for 0, 1 and 2 elements is constant
		counterArray[0] = counterArray[1] = 1;
		counterArray[2] = 2;
		
		//we take natural numbers one by one
		for(int i = 3; i < counterArray.length; i++) {
			//if this one is in the set of input data  
			if(data.contains(i)) {
				//we sum three numbers placed before this number and put it in our counter
				for(int j = i - 3; j < i; j++) {
					counterArray[i] += counterArray[j];
				}
			} else {
				//if it is not in the set we store the value 0
				counterArray[i] = 0;
			}
		}

		//last element contains the sum of all possible arrangements
		return counterArray[max];
	}
}
