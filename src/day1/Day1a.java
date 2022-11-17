package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import operations.GeneralStreamOperations;
import operations.StringStreamOperations;

public class Day1a {

	public static void main(String[] args) {
		Stream<String> input = null;
		String inputFileName = "day1a.txt";
		
		input = readStringStreamFromFile(inputFileName);

		//////
		Function<Stream<String>,Stream<Integer>> func = StringStreamOperations::toInteger;
		
		Function<Stream<Integer>,List<Integer>> func2 = GeneralStreamOperations::toList;
		
		List<Integer> waterDepths = func.andThen(func2).apply(input);
		///
		
		int depthsGreaterThanPreviousDepths = countGreaterThanPreviousInList(waterDepths);
		
		System.out.println(depthsGreaterThanPreviousDepths);
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
