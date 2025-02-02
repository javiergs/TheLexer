import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LexerTestOne class to test the Lexer class
 * This version is implemented with JUnit 5
 *
 * @author javiergs
 * @version 1.0
 */
class LexerTest {
	
	@Test
	void testingFileInput() throws IOException {
		File file = new File("src/main/resources/input.txt");
		Lexer lexer = new Lexer(file);
		lexer.run();
		List<Token> tokens = lexer.getTokens();
		assertAll("Lexer Output",
			() -> assertEquals("ERROR", tokens.get(0).getType(), "int should be ERROR"),
			() -> assertEquals("ERROR", tokens.get(1).getType(), "x should be ERROR"),
			() -> assertEquals("OPERATOR", tokens.get(2).getType(), "= should be OPERATOR"),
			() -> assertEquals("ERROR", tokens.get(3).getType(), "0b00A should be ERROR"),
			() -> assertEquals("DELIMITER", tokens.get(4).getType(), ", should be DELIMITER"),
			() -> assertEquals("ERROR", tokens.get(5).getType(), "0b01Z should be ERROR"),
			() -> assertEquals("BINARY", tokens.get(6).getType(), "0b10 should be BINARY"),
			() -> assertEquals("BINARY", tokens.get(7).getType(), "0b11 should be BINARY"),
			() -> assertEquals("DELIMITER", tokens.get(8).getType(), "; should be DELIMITER"),
			() -> assertEquals("ERROR", tokens.get(9).getType(), "3 should be ERROR"),
			() -> assertEquals("OPERATOR", tokens.get(10).getType(), "- should be OPERATOR"),
			() -> assertEquals("BINARY", tokens.get(11).getType(), "0b111 should be BINARY"),
			() -> assertEquals("ERROR", tokens.get(12).getType(), "end should be ERROR"),
			() -> assertEquals("ERROR", tokens.get(13).getType(), "1111 should be ERROR"),
			() -> assertEquals("ERROR", tokens.get(14).getType(), "end should be ERROR"),
			() -> assertEquals("BINARY", tokens.get(15).getType(), "0b1111 should be BINARY"),
			() -> assertEquals("ERROR", tokens.get(16).getType(), "hello should be ERROR"),
			() -> assertEquals("ERROR", tokens.get(17).getType(), "world should be ERROR"),
			() -> assertEquals("ERROR", tokens.get(18).getType(), "eND. should be ERROR")
		);
		assertEquals(19, tokens.size(), "Number of tokens should be 19");
		System.out.println("Test passed.");
	}
	
}
