package aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public final class InputReader {

	private InputReader() {}
	
	public static List<String> getLines(String filePath) {
		Path path = Paths.get(filePath);
		List<String> contents = Collections.emptyList();
		
		try {
			contents = Files.readAllLines(path);
		} catch(IOException ex) {
			 ex.printStackTrace();
		}
		
		return contents;
	}
}
