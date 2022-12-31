package day1;

import java.util.List;
import java.util.stream.Collectors;
import fileReader.ScanFile;

public class Day1a {

	public static void main(String[] args) {
		String inputFileName = "day1a.txt";
		
		List<Integer> waterDepths = 
			ScanFile.readAdventFile(inputFileName)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
		
		int depthsGreaterThanPreviousDepths = countGreaterThanPreviousInList(waterDepths);
		
		System.out.println(depthsGreaterThanPreviousDepths);
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
