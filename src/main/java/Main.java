import java.io.File;
import java.io.IOException;

/**
 * Main class to run the lexer
 *
 * @author javiergs
 * @version 1.0
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/input.txt");
		Lexer lexer = new Lexer(file);
		lexer.run();
		lexer.printTokens();
	}
	
}