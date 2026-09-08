package stack;

public class MatchToken {
	String string;
	private LinkedStack<String> haakstack= new LinkedStack();
	private LinkedStack<String> htmlstack = new LinkedStack();
	public MatchToken(String s) {
		this.string=s;
	}
	
	public boolean match() {
		boolean match = true;
		char kar;
		for (int j=0; j<string.length() ;j++) {
			if (string.charAt(j) == '(') {
				haakstack.push("dummy");
			}
			if (string.charAt(j) == ')') {
				if (haakstack.isEmpty()) {
					return false;
				}
				else {
					haakstack.pop();
				}
			}
			if (string.charAt(j) == '<') {
				htmlstack.push("dummy");
			}
			if (string.charAt(j) == '>') {
				if (htmlstack.isEmpty()) {
					return false;
				}
				else {
					htmlstack.pop();
				}
			}
		}
		if (!htmlstack.isEmpty() || !haakstack.isEmpty()) {
			match = false;
		}
		return match;
	}

}
