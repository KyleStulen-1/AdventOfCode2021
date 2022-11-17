package operations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface GeneralStreamOperations {
	static <T> List<T> toList(Stream<T> stream){
		return stream.collect(Collectors.toList());
	}
}
