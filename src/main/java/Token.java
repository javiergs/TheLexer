/**
 * A Token is a pair of a value (string or word) and its type
 *
 * @author javiergs
 * @version 1.0
 */
public class Token {
	
	private String value;
	private String type;
	
	public Token(String value, String type) {
		this.value = value;
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getType() {
		return type;
	}
	
}

