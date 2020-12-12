package aoc.logic;

import static aoc.enums.FerryAction.EAST;
import static aoc.enums.FerryAction.NORTH;
import static aoc.enums.FerryAction.SOUTH;
import static aoc.enums.FerryAction.WEST;

import aoc.enums.FerryAction;
import aoc.utils.CircularList;

public class FerryWithoutWaypoint implements Ferry {
	private final CircularList<FerryAction> directions = CircularList.of(EAST, SOUTH, WEST, NORTH);
	private FerryAction direction = EAST;
	private int eastWestPosition = 0;
	private int northSouthPosition = 0;
	
	@Override
	public void move(FerryAction action, int value) {
		switch(action) {
		case EAST:
			moveEastWest(value);
			break;
		case WEST:
			moveEastWest(-1 * value);
			break;
		case NORTH:
			moveNorthSouth(value);
			break;
		case SOUTH:
			moveNorthSouth(-1 * value);
			break;
		case RIGHT:
			turnRightLeft(value);
			break;
		case LEFT:
			turnRightLeft(-1 * value);
			break;
		case FORWARD:
			moveForward(value);
			break;
		}
	}
	
	private void turnRightLeft(int degree) {
		direction = directions.get(direction, degree / 90);
	}
	
	private void moveEastWest(int distance) {
		eastWestPosition += distance;
	}
	
	private void moveNorthSouth(int distance) {
		northSouthPosition += distance;
	}
	
	private void moveForward(int distance) {
		move(direction, distance);
	}
	
	@Override
	public int calculateManhattanDistance() {
		return Math.abs(eastWestPosition) + Math.abs(northSouthPosition);
	}
}
