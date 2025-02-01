import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/input.txt");
		Lexer lexer = new Lexer(file);
		lexer.run();
		lexer.printTokens();
	}

}

