package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import operations.StringStreamOperations;
import operations.GeneralStreamOperations;

public class Day1b {
	public static void main(String[] args) {
		Stream<String> input = null;
		int slidingWindowSize = 3;
		String inputFileName = "day1a.txt";
		
		input = readStringStreamFromFile(inputFileName);

		//////
		Function<Stream<String>,Stream<Integer>> func = StringStreamOperations::toInteger;
		
		Function<Stream<Integer>,List<Integer>> func2 = GeneralStreamOperations::toList;
		
		List<Integer> waterDepths = func.andThen(func2).apply(input);
		///////
		
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
	
	static Stream<String> readStringStreamFromFile(String fileName) {
		Stream<String> stream = null;
		try {
			stream = Files.lines(Path.of(System.getProperty("user.dir"), "src", "inputs", fileName));
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		return stream;
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
