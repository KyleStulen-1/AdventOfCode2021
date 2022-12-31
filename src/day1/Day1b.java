package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fileReader.ScanFile;

public class Day1b {
	public static void main(String[] args) {
		Stream<String> input = null;
		int slidingWindowSize = 3;
		String inputFileName = "day1a.txt";
		
		List<Integer> waterDepths = 
				ScanFile.readFileToStringStream(
					ScanFile.createLocalFilePath(inputFileName))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		
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
