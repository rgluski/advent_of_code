package aoc.logic;

import static aoc.enums.FerryAction.EAST;
import static aoc.enums.FerryAction.NORTH;
import static aoc.enums.FerryAction.SOUTH;
import static aoc.enums.FerryAction.WEST;

import aoc.enums.FerryAction;
import aoc.types.CircularList;

public class FerryWithWaypoint implements Ferry {
	private final CircularList<FerryAction> directions = CircularList.of(EAST, SOUTH, WEST, NORTH);
	private FerryAction waypointDirection1;
	private FerryAction waypointDirection2;
	private int waypointPosition1;
	private int waypointPosition2;
	private int ferryEastWestPosition = 0;
	private int ferryNorthSouthPosition = 0;
	
	public FerryWithWaypoint(FerryAction waypointDirection1, int waipointPosition1, FerryAction waypointDirection2, int waipointPosition2) {
		this.waypointDirection1 = waypointDirection1;
		this.waypointPosition1 = waipointPosition1;
		this.waypointDirection2 = waypointDirection2;
		this.waypointPosition2 = waipointPosition2;
	}
	
	@Override
	public void move(FerryAction action, int value) {
		switch(action) {
		case EAST:
			moveWaypointEastWest(value);
			break;
		case WEST:
			moveWaypointEastWest(-1 * value);
			break;
		case NORTH:
			moveWaypointNorthSouth(value);
			break;
		case SOUTH:
			moveWaypointNorthSouth(-1 * value);
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
	
	private void moveWaypointEastWest(int distance) {
		moveWaypoint(distance, EAST, WEST);
	}
	
	private void moveWaypointNorthSouth(int distance) {
		moveWaypoint(distance, NORTH, SOUTH);
	}
	
	//Because of rotation implementation axis WE and SN swap between two sets of coordinates. This logic is to set correct one.
	private void moveWaypoint(int distance, FerryAction action1, FerryAction action2) {
		if(waypointDirection1 == action1) {
			waypointPosition1 += distance;
		} else if (waypointDirection1 == action2) {
			waypointPosition1 -= distance;
		}
		
		if(waypointDirection2 == action1) {
			waypointPosition2 += distance;
		} else if (waypointDirection2 == action2) {
			waypointPosition2 -= distance;
		}
	}
	
	private void turnRightLeft(int degree) {
		int offset = degree / 90;
		waypointDirection1 = directions.get(waypointDirection1, offset);
		waypointDirection2 = directions.get(waypointDirection2, offset);
	}
	
	private void moveForward(int distance) {
		moveFerry(waypointDirection1, waypointPosition1 * distance);
		moveFerry(waypointDirection2, waypointPosition2 * distance);
	}
	
	private void moveFerry(FerryAction action, int distance) {
		switch(action) {
		case EAST:
			moveFerryEastWest(distance);
			break;
		case WEST:
			moveFerryEastWest(-1 * distance);
			break;
		case NORTH:
			moveFerryNorthSouth(distance);
			break;
		case SOUTH:
			moveFerryNorthSouth(-1 * distance);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void moveFerryEastWest(int distance) {
		ferryEastWestPosition += distance;
	}
	
	private void moveFerryNorthSouth(int distance) {
		ferryNorthSouthPosition += distance;
	}

	@Override
	public int calculateManhattanDistance() {
		return Math.abs(ferryEastWestPosition) + Math.abs(ferryNorthSouthPosition);
	}
}