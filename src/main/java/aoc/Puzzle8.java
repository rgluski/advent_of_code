package aoc;

import java.util.Arrays;
import java.util.List;

import aoc.enums.Operation;
import aoc.exceptions.UnsolvableException;
import aoc.pojo.Instruction;
import aoc.utils.InputReader;

import static aoc.enums.Operation.*;

public class Puzzle8 implements Puzzle<Instruction[]> {
	
	@Override
	public Instruction[] getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		return lines.stream().map(x -> {
			String[] instr = x.split("\\s");
			return new Instruction(Operation.valueOf(instr[0].toUpperCase()), Integer.parseInt(instr[1]));
		}).toArray(Instruction[]::new);
	}

	@Override
	public long resolvePart1(Instruction[] data) {
		return resolve(data, true);
	}
	
	@Override
	public long resolvePart2(final Instruction[] data) {
		long result = 0L;
		
		for(int i = 0; i < data.length; i++) {
			Instruction[] copy = Arrays.copyOf(data, data.length);
			Instruction instr = copy[i];
			
			if(instr.getOperation() == NOP) {
				copy[i] = new Instruction(JMP, instr.getArgument());
			} else if(instr.getOperation() == JMP) {
				copy[i] = new Instruction(NOP, instr.getArgument());
			}
			
			try {
				result = resolve(copy, false);
				
				return result;
			} catch(UnsolvableException e) {
				//do nothing, check for another possible solution
			}
		}
		
		return result;
	}
	
	private long resolve(Instruction[] data, boolean breakOnfiniteLoop) {
		boolean[] visited = new boolean[data.length];
		long accumulator = 0L;
		int index = 0;
		
		while(index < data.length) {
			if(visited[index]) {
				if(breakOnfiniteLoop) {
					return accumulator;
				} else {
					throw new UnsolvableException();
				}
			}
			
			Instruction instr = data[index];
			visited[index] = true;

			switch(instr.getOperation()) {
				case NOP:
					index++;
					break;
				case ACC:
					accumulator += instr.getArgument();
					index++;
					break;
				case JMP:
					index += instr.getArgument();
					break;
			}
		}

		return accumulator;
	}
}
