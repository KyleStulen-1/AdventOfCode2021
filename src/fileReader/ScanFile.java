package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface ScanFile {
	static Stream<String> readFileToStringStream(Path filePath) {
		Stream<String> stream = Stream.empty();
		try {
			stream = Files.lines(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stream;
	}
	static Path createLocalFilePath(String fileName) {
		return Path.of(System.getProperty("user.dir"), "src", "inputs", fileName);
	}
}
