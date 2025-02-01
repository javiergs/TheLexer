import java.io.*;
import java.util.Vector;

public class Lexer {
	
	private File file;
	private Automata dfa;
	private Vector<Token> tokens;
	
	public Lexer(File file) {
		this.file = file;
		tokens = new Vector<>();
		dfa = new Automata();
		dfa.addTransition("s0", "0", "s1");
		dfa.addTransition("s1", "b", "s2");
		dfa.addTransition("s1", "B", "s2");
		dfa.addTransition("s2", "0", "s3");
		dfa.addTransition("s2", "1", "s3");
		dfa.addTransition("s3", "0", "s3");
		dfa.addTransition("s3", "1", "s3");
		
		dfa.addAcceptState("s3", "BINARY");
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			algorithm(line);
		}
	}
	
	private void algorithm(String line) {
		String currentState = "s0";
		String nextState;
		String string = "";
		int index = 0;
		
		while (index < line.length()) {
			char currentChar = line.charAt(index);
			if (! (isOperator(currentChar) || isDelimiter(currentChar) || isSpace(currentChar))) {
				nextState = dfa.getNextState(currentState, currentChar);
				string = string + currentChar;
				currentState = nextState;
			} else {
				if (dfa.isAcceptState(currentState)) {
					String stateName = dfa.getAcceptStateName(currentState);
					tokens.add(new Token(string, stateName));
				} else if (currentState != "s0") {
					tokens.add(new Token(string, "ERROR"));
				}
				if (isOperator(currentChar)) {
					tokens.add(new Token(currentChar + "", "OPERATOR"));
				} else if (isDelimiter(currentChar)) {
					tokens.add(new Token(currentChar + "", "DELIMITER"));
				}
				currentState = "s0";
				string = "";
			}
			index++;
		}
		// last word
		if (dfa.isAcceptState(currentState)) {
			String stateName = dfa.getAcceptStateName(currentState);
			tokens.add(new Token(string, stateName));
		} else if (currentState != "s0") {
			tokens.add(new Token(string, "ERROR"));
		}
	}
	
	private boolean isSpace(char c) {
		return c == ' ' || c == '\t' || c == '\n';
	}
	
	private boolean isDelimiter(char c) {
		return c == ',' || c == ';';
	}
	
	private boolean isOperator(char c) {
		return c == '=' || c == '+' || c == '-' || c == '*' || c == '/';
	}
	
	public void printTokens() {
		for (Token token : tokens) {
			System.out.printf("%10s\t|\t%s\n", token.getValue(), token.getType());
		}
	}
	
}



