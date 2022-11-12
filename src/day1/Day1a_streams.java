package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Day1a_streams {
	
	public static void main(String[] args) throws IOException {
		Stream<Integer> integerStream = streamStringToInteger(readStringStreamFromFile("day1a.txt"));
		
		AtomicInteger countGreaterThanPreviousInSeries = new AtomicInteger(0);
		
		integerStream.reduce((Integer previous, Integer current) ->{
			if (previous < current) {
				countGreaterThanPreviousInSeries.getAndIncrement();
			}
			return current;
		});
		
		System.out.println(countGreaterThanPreviousInSeries.get());
	}
	
	static Stream<Integer> streamStringToInteger(Stream<String> stringStream){
		return stringStream.map(Integer::valueOf);
	}
	
	static Stream<String> readStringStreamFromFile(String fileName) throws IOException{
		return Files.lines(Path.of(System.getProperty("user.dir"), "src", "inputs", fileName));
	}
}
