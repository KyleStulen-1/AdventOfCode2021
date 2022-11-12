package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day1b {
	public static void main(String[] args) {
		List<Integer> waterDepths = null;
		int slidingWindowSize = 3;
		String inputFileName = "day1a.txt";
		
		try {
			waterDepths = readStringStreamFromFileToIntegerArray(inputFileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("unable to read file");
			System.exit(0);
		}
		
		List<Integer> calculatedSlidingWindowValues = calculateSlidingWindow(waterDepths, slidingWindowSize);
		
		int depthsGreaterThanPreviousDepths = countGreaterThanPreviousInList(calculatedSlidingWindowValues);
		
		System.out.println(depthsGreaterThanPreviousDepths);
	}
	
	static List<Integer> calculateSlidingWindow(List<Integer> list, int windowSize){
		List<Integer> calculatedSlidingWindowValues = new ArrayList<Integer>();
		
		for (int i = 0; i <= list.size()-windowSize; i++) {
			calculatedSlidingWindowValues.add(list.get(i) + list.get(i+1) + list.get(i+2));
		}
		
		return calculatedSlidingWindowValues;
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
