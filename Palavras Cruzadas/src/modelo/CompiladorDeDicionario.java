package modelo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class CompiladorDeDicionario {

	static List<String> readFile(String path, Charset encoding)
			throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path), encoding);
		return lines;
	}

}