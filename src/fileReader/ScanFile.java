package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;
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
	
	static Path createLocalFilePath(String fileName, String... FolderNames) {
		StringJoiner folders = new StringJoiner("\\");
		for (String s: FolderNames) {
			folders.add(s);
		}
		return Path.of(System.getProperty("user.dir"), folders.toString(), fileName);
	}
	
	static Stream<String> readAdventFile(String fileName){
		Path filePath = createLocalFilePath(fileName, "src", "inputs");
		
		return readFileToStringStream(filePath);
	}
}
