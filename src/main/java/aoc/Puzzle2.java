package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import aoc.pojo.PasswordWithPolicy;
import aoc.utils.InputReader;

public class Puzzle2 implements Puzzle<List<PasswordWithPolicy>> {

	@Override
	public List<PasswordWithPolicy> getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return lines.stream().map(line -> {
			String[] values = line.split("\\s|-");
			
			return new PasswordWithPolicy(Integer.parseInt(values[0]),
											Integer.parseInt(values[1]),
											values[2].charAt(0),
											values[3]);
		}).collect(Collectors.toCollection(ArrayList::new));
	}
	
	@Override
	public long resolvePart1(List<PasswordWithPolicy> data) {
		return data.stream().filter(x -> {
			long count = x.password.chars().filter(ch -> ch == x.letter).count();
			
			return count >= x.firstNum && count <= x.secondNum;
		}).count();
	}
	
	@Override
	public long resolvePart2(List<PasswordWithPolicy> data) {
		return data.stream()
				.filter(x -> x.password.charAt(x.firstNum - 1) == x.letter ^ x.password.charAt(x.secondNum - 1) == x.letter).count();
	}
}
