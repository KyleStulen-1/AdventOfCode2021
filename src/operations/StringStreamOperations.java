package operations;

import java.util.stream.Stream;

public interface StringStreamOperations {
	static Stream<Integer> toInteger(Stream<String> stream){
		return stream.map(Integer::valueOf);
	}
}
