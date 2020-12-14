package aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc.exceptions.UnsolvableException;
import aoc.types.Pair;
import aoc.utils.InputReader;

public class Puzzle13 implements Puzzle<Pair<Integer, List<Integer>>> {

	@Override
	public Pair<Integer, List<Integer>> getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return new Pair<>(Integer.parseInt(lines.get(0)),
				Arrays.stream(lines.get(1).split(","))
					.mapToInt(x -> "x".equals(x) ? -1 : Integer.parseInt(x))
					.boxed().collect(Collectors.toList()));
	}

	@Override
	public long resolvePart1(Pair<Integer, List<Integer>> data) {
		final int desidredTime = data.getKey();

		int minToWaitBusId = data.getValue().stream().filter(x -> x != -1)
				.min((a, b) -> Long.compare(getEarliestTime(desidredTime, a), getEarliestTime(desidredTime, b)))
				.orElseThrow(UnsolvableException::new);
		
		return (getEarliestTime(desidredTime, minToWaitBusId) - desidredTime) * minToWaitBusId;
	}

	private long getEarliestTime(long desidredTime, long busCycleTime) {
		return (desidredTime / busCycleTime) * busCycleTime + busCycleTime;
	}
	
	@Override
	public long resolvePart2(Pair<Integer, List<Integer>> data) {
		//Not solved yet
		
		return -1;
	}
}
