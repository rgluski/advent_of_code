package aoc;

import java.util.List;

import aoc.enums.SeatState;
import aoc.pojo.Seat;
import aoc.utils.InputReader;

public class Puzzle11 implements Puzzle<Seat[][]> {

	@Override
	public Seat[][] getInputData(String filePath) {
		List<String> lines = InputReader.getLines(filePath);
		
		Seat[][] data = new Seat[lines.size()][];
		
		for(int i = 0; i < lines.size(); i++) {
			char[] rowSeats = lines.get(i).toCharArray();
			data[i] = new Seat[rowSeats.length];
			
			for(int j = 0; j < rowSeats.length; j++) {
				data[i][j] = new Seat(SeatState.valueOf(rowSeats[j]));
			}
		}
		
		fillNeighborsForAllSeats(data);
		
		return data;
	}

	public static void fillNeighborsForAllSeats(Seat[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				fillNeighborsForSeat(data, i, j);
			}
		}
	}
	
	private static void fillNeighborsForSeat(Seat[][] data, int row, int col) {
		for(int i = -1; i <= 1; i++) {
			int neighborRow = row + i;
			for(int j = -1; j <= 1; j++) {
				int neighborCol = col + j;
				if(neighborRow >= 0 && neighborCol >= 0 && neighborRow < data.length && neighborCol < data[row].length && !(i == 0 && j == 0)) {
					Seat neighbor = data[neighborRow][neighborCol];
					data[row][col].setNeighbor(i, j, neighbor);
				}
			}
		}
	}

	@Override
	public long resolvePart1(Seat[][] data) {
		return resolve(data, 1, 4);
	}

	@Override
	public long resolvePart2(Seat[][] data) {
		return resolve(data, Math.max(data.length, data[0].length), 5);
	}
	
	private long resolve(Seat[][] data, int levelOfSearch, int visibleSeatsCount) {
		Seat[][] beforeRound;
		Seat[][] afterRound = data;
		
		do {
			beforeRound = afterRound;
			afterRound = round(beforeRound, levelOfSearch, visibleSeatsCount);
		} while(!sameSeatsAraangement(beforeRound, afterRound));
		
		return countAllOccupiedSeats(afterRound);
	}
	
	private Seat[][] round(Seat[][] data, int levelOfSearch, int visibleSeatsCount) {
		Seat[][] newData = copyAllSeats(data);
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(freeSeat(data[i][j]) && countOccupiedNeighbors(data[i][j], levelOfSearch) == 0) {
					newData[i][j].setState(SeatState.OCCUPIED);
				} else if(occupiedSeat(data[i][j]) && countOccupiedNeighbors(data[i][j], levelOfSearch) >= visibleSeatsCount) {
					newData[i][j].setState(SeatState.FREE);
				}
			}
		}
		
		return newData;
	}
	
	private Seat[][] copyAllSeats(Seat[][] data) {
		Seat[][] copy = new Seat[data.length][data[0].length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				copy[i][j] = new Seat(data[i][j].getState());
			}
		}
		fillNeighborsForAllSeats(copy);
		
		return copy;
	}
	
	private boolean freeSeat(Seat seat) {
		return seat.getState() == SeatState.FREE;
	}
	
	private boolean occupiedSeat(Seat seat) {
		return seat.getState() == SeatState.OCCUPIED;
	}
	
	private int countOccupiedNeighbors(Seat seat, int levelOfSearch) {
		int count = 0;
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				int level = 0;
				Seat neighbor = seat.getNeighbor(i, j);
				while(level < levelOfSearch && neighbor != null && !freeSeat(neighbor)) {
					if(occupiedSeat(neighbor)) {
						count++;
						break;
					}
					
					neighbor = neighbor.getNeighbor(i, j);
					level++;
				}
			}
		}
		
		return count;
	}
	
	private boolean sameSeatsAraangement(Seat[][] before, Seat[][] after) {
		for(int i = 0; i < before.length; i++) {
			for(int j = 0; j < before[i].length; j++) {
				if(before[i][j].getState() != after[i][j].getState()) {
					return false;
				}
			}
		}
		
		return true;
	}

	private long countAllOccupiedSeats(Seat[][] data) {
		long count = 0L;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(occupiedSeat(data[i][j])) {
					count++;
				}
			}
		}
		
		return count;
	}
}
