package aoc.logic;

import aoc.enums.FerryAction;

public interface Ferry {
	void move(FerryAction action, int value);
	int calculateManhattanDistance();
}
