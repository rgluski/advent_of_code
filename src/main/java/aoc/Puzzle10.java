package aoc;

import java.util.Collections;
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
		long[] counter = {0, 0, 0, 1};
		
		data.stream().reduce(0, (a, b) -> {
			int diff = b - a;
			if(diff > 3) {
				throw new UnsolvableException();
			}
			counter[diff]++;

			return b;
		});
		
		return counter[1] * counter[3];
	}

	@Override
	public long resolvePart2(Set<Integer> data) {
		final int max = Collections.max(data);
		
		//we have array with zeroes from 0 to max number in the adapters set
		long[] counterArray = new long[max + 1];
		
		//there is always 0 adapter
		counterArray[0] = 1;

		//we take natural numbers one by one
		for(int i = 1; i < counterArray.length; i++) {
			//if this one is in the set of input data  
			if(data.contains(i)) {
				//we sum three numbers placed before the current number and put this sum in our counter
				int j = i - 3 < 0 ? 0 : i - 3;
				while(j < i) {
					counterArray[i] += counterArray[j++];
				}
			}
		}

		//last element contains the sum of all possible arrangements
		return counterArray[max];
	}
}
