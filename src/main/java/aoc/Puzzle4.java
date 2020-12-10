package aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.InputReader;
import aoc.validators.PassportValidator;

public class Puzzle4 implements Puzzle<List<Map<String, String>>> {
	private PassportValidator validator = new PassportValidator();
	
	@Override
	public List<Map<String, String>> getInputData(String filePath) {
		List<Map<String, String>> data = new ArrayList<>();
		Map<String, String> passportMap = new HashMap<>();
		
		List<String> lines = InputReader.getLines(filePath);

		for(String line : lines) {
			if(line.isBlank() && !passportMap.isEmpty()) {
				data.add(passportMap);
				passportMap = new HashMap<>();
				continue;
			}
			String[] fields = line.split("\\s");
			for(String field : fields) {
				String[] pair = field.split(":");
				passportMap.put(pair[0], pair[1]);
			}
		}
		if(!passportMap.isEmpty()) {
			data.add(passportMap);
		}
		return data;
	}
	
	@Override
	public long resolvePart1(List<Map<String, String>> data) {
		return data.stream().filter(validator::allRequiredFields).count();
	}
	
	@Override
	public long resolvePart2(List<Map<String, String>> data) {
		return data.stream().filter(validator::allRequiredFields).filter(validator::validateFields).count();
	}
}
