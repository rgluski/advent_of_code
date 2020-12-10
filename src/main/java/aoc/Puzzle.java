package aoc;

interface Puzzle<T> {
	T getInputData(String filePath);
	long resolvePart1(T data);
	long resolvePart2(T data);
}
