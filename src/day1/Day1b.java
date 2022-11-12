package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day1b {
	public static void main(String[] args) {
		List<Integer> waterDepths = null;
		try {
			waterDepths = readStringStreamFromFileToIntegerArray("day1a.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("unable to read file");
			System.exit(0);
		}
		
		int depthsGreaterThanPreviousDepths = countGreaterThanPreviousInList(waterDepths);
		
		System.out.println(depthsGreaterThanPreviousDepths);
	}
	
	static List<Integer> readStringStreamFromFileToIntegerArray(String fileName) throws IOException {
		return Files.lines(Path.of(System.getProperty("user.dir"), "src", "inputs", fileName))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}
	
	static int countGreaterThanPreviousInList(List<Integer> list) {
		int counter = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > list.get(i-1)) {
				counter++;
			}
		}
		return counter;
	}
}
