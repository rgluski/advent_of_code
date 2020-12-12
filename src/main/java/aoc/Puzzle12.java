package aoc;

import java.util.List;
import java.util.stream.Collectors;

import aoc.enums.FerryAction;
import aoc.logic.Ferry;
import aoc.logic.FerryWithWaypoint;
import aoc.logic.FerryWithoutWaypoint;
import aoc.pojo.FerryInstruction;
import aoc.utils.InputReader;

import static aoc.enums.FerryAction.*;

public class Puzzle12 implements Puzzle<List<FerryInstruction>> {

	@Override
	public List<FerryInstruction> getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return lines.stream()
				.map(line -> new FerryInstruction(FerryAction.valueOf(line.charAt(0)), Integer.parseInt(line.substring(1))))
				.collect(Collectors.toList());
	}

	@Override
	public long resolvePart1(List<FerryInstruction> data) {
		return resolve(data, new FerryWithoutWaypoint());
	}

	@Override
	public long resolvePart2(List<FerryInstruction> data) {
		return resolve(data, new FerryWithWaypoint(EAST, 10, NORTH, 1));
	}
	
	public long resolve(List<FerryInstruction> data, Ferry ferry) {
		data.stream().forEach(instr -> ferry.move(instr.getAction(), instr.getValue()));
		
		return ferry.calculateManhattanDistance();
	}
}
