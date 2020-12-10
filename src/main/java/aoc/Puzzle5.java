package aoc;

import java.util.List;

import aoc.exceptions.UnsolvableException;
import aoc.utils.InputReader;

public class Puzzle5 implements Puzzle<List<String>> {

	@Override
	public List<String> getInputData(String filePath) {
		return InputReader.getLines(filePath);
	}
	
	@Override
	public long resolvePart1(List<String> data) {
		return data.stream().mapToInt(this::convertToSeatId).max().getAsInt();
	}
	
	@Override
	public long resolvePart2(List<String> data) {
		int[] seats = data.stream().mapToInt(this::convertToSeatId).sorted().toArray();

		for(int i = 0; i < seats.length - 1; i++) {
			if(seats[i + 1] - seats[i] == 2) {
				return seats[i] + 1L;
			}
		}
		
		throw new UnsolvableException();
	}

	private int convertToSeatId(String seatCode) {
		String seatBinaryCode = seatCode.replaceAll("F|L", "0").replaceAll("B|R", "1");
		int row = Integer.parseInt(seatBinaryCode.substring(0, 7), 2);
		int column = Integer.parseInt(seatBinaryCode.substring(7), 2);
		return row * 8 + column;
	}
}
