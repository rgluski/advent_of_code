package aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.utils.InputReader;

public class Puzzle7 implements Puzzle<Map<String, Map<String, Integer>>> {
	private static final String SHINY_GOLD_BAG = "shiny gold";
	
	@Override
	public Map<String, Map<String, Integer>> getInputData(String filePath) {
		Map<String, Map<String, Integer>> data = new HashMap<>();
		
		List<String> lines = InputReader.getLines(filePath);

		for(String line : lines) {
			String[] ruleParts = line.split(" bags contain | bag, | bags, | bags.| bag.");
			Map<String, Integer> nestedBags = new HashMap<>();
			if(!ruleParts[1].matches("no other")) {
				for(int i = 1; i < ruleParts.length; i++) {
					int bagsCount = Integer.parseInt(ruleParts[i].substring(0, ruleParts[i].indexOf(" ")));
					String bagColor = ruleParts[i].substring(ruleParts[i].indexOf(" ") + 1);
					nestedBags.put(bagColor, bagsCount);
				}
			}
			data.put(ruleParts[0], nestedBags);
		}

		return data;
	}

	@Override
	public long resolvePart1(Map<String, Map<String, Integer>> data) {
		return data.keySet().stream().filter(x -> containShinyGoldBag(x, data)).count();
	}
	
	private boolean containShinyGoldBag(String bagColor, Map<String, Map<String, Integer>> rules) {
		if(rules.get(bagColor).containsKey(SHINY_GOLD_BAG)) {
			return true;
		}

		return rules.get(bagColor).keySet().stream().anyMatch(x -> containShinyGoldBag(x, rules));
	}
	
	@Override
	public long resolvePart2(Map<String, Map<String, Integer>> data) {
		return countNestedBags(SHINY_GOLD_BAG, data);
	}
	
	private long countNestedBags(String bagColor, Map<String, Map<String, Integer>> rules) {
		if(rules.get(bagColor).isEmpty()) {
			return 0L;
		}

		return rules.get(bagColor).entrySet().stream()
				.mapToLong(x -> x.getValue() * (1 + countNestedBags(x.getKey(), rules)))
				.sum();
	}
}
