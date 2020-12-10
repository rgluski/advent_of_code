package aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import aoc.utils.InputReader;

public class Puzzle6 implements Puzzle<List<List<String>>> {

	@Override
	public List<List<String>> getInputData(String filePath) {
		List<List<String>> data = new ArrayList<>();
		List<String> group = new ArrayList<>();
		
		List<String> lines = InputReader.getLines(filePath);
		
		for(String line : lines) {
			if(line.isBlank()) {
				data.add(group);
				group = new ArrayList<>();
				continue;
			}
			group.add(line);
		}
		
		if(!group.isEmpty()) {
			data.add(group);
		}
		
		return data;
	}
	
	@Override
	public long resolvePart1(List<List<String>> data) {
		return data.stream().mapToInt(
				x -> x.stream().flatMapToInt(String::chars).boxed().collect(Collectors.toSet()).size()
			).sum();
	}
	
	@Override
	public long resolvePart2(List<List<String>> data) {
		return data.stream()
				.mapToInt(x -> x.stream()
					.map(y -> y.chars().boxed().collect(Collectors.toSet()))
					.reduce((a, b) -> {
						a.retainAll(b);
						return a;
					}).orElse(Collections.emptySet()).size()
				).sum();
	}
}
