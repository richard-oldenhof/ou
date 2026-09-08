package stack;

public class MatchTokenAlt {
	String string;
	private LinkedStack<String> linkstack= new LinkedStack();
	private ArrayStack<String>  arraytack = new ArrayStack();
	private String opentokens = "<({";
	private String closetokens = ">)}";
	
	public MatchTokenAlt(String s) {
		this.string=s;
	}
	
	public boolean match() {
		boolean match = true;	
		for (int j=0;j<string.length();j++) {
			if (opentokens.indexOf(string.charAt(j))> -1) {
				linkstack.push(String.valueOf(string.charAt(j)));
			}
			if (closetokens.indexOf(string.charAt(j))> -1) {
				if (linkstack.isEmpty()) {
					return false;
				}
				if (!(opentokens.indexOf(linkstack.pop()) == closetokens.indexOf(string.charAt(j)))) {
					match = false;
				}
			}
			
		}
		if (!linkstack.isEmpty()) {
			match = false;
		}
		return match;
	}

}
