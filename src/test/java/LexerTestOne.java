import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LexerTestOne class to test the Lexer class
 * This version is implemented with JUnit 5
 *
 * @author javiergs
 * @version 1.0
 */
class LexerTestOne {
	
	@Test
	void testingNumberOfTokens() throws IOException {
		File file = new File("src/main/resources/input.txt");
		Lexer lexer = new Lexer(file);
		lexer.run();
		assertFalse (lexer.getTokens().isEmpty(), "Tokens should not be empty");
		assertEquals(lexer.getTokens().size(), 19, "Number of tokens should be 19");
		System.out.println("Test passed.");
	}
	
}
