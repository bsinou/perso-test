package net.sinou.tutorials.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class NioPuzzles {

	/**
	 *
	 * @param args
	 *            a {@link java.lang.String} object.
	 */
	public static void main(String... args) {

		NioPuzzles np = new NioPuzzles();
		try {
			np.fileAppendPuzzle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private final static String TMP_PATH = "/home/bsinou/tmp/";
	private final static String ENCODING = "utf-8";

	/** What will be printed? */
	private void fileAppendPuzzle() throws IOException {
		System.out.println("== FileAppend Puzzle");

		Path firstPath = Paths.get(TMP_PATH + "first_notes.txt");
		Path secondPath = Paths.get(TMP_PATH + "second_notes.txt");
		Path thirdPath = Paths.get(TMP_PATH + "third_notes.txt");

		if (!Files.exists(firstPath))
			Files.createFile(firstPath);
		
		Files.write(firstPath, "I love bacon.".getBytes(ENCODING), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		Files.copy(firstPath, secondPath, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(secondPath, thirdPath, StandardCopyOption.REPLACE_EXISTING);

		Files.write(thirdPath, "Eat my shorts.".getBytes(ENCODING), StandardOpenOption.APPEND);
		Files.write(thirdPath, "D'oh!".getBytes(ENCODING), StandardOpenOption.APPEND);
	}
}
