package aoc.pojo;

import aoc.enums.SeatState;

public class Seat {
	private SeatState state;
	private Seat[][] neighbors = new Seat[3][3];

	public Seat(SeatState state) {
		this.state = state;
	}
	
	public Seat(char state) {
		this.state = SeatState.valueOf(state);
	}
	
	public void setState(SeatState state) {
		this.state = state;
	}
	
	public SeatState getState() {
		return state;
	}
	
	public void setNeighbor(int upDown, int leftRight, Seat neighbor) {
		neighbors[upDown + 1][leftRight + 1] = neighbor;
	}
	
	public Seat getNeighbor(int upDown, int leftRight) {
		return neighbors[upDown + 1][leftRight + 1];
	}
}
