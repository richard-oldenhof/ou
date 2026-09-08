package stack;

public class TestMatchToken {

	public static void main(String[] args) {
		String teststring = "<{)}>";
		MatchToken string = new MatchToken(teststring);
		MatchTokenAlt stringalt = new MatchTokenAlt(teststring);
		if (string.match()) {
			System.out.println(teststring + " Match");
		}
		else {
			System.out.println(teststring + " Geen Match");
		}
		if (stringalt.match()) {
			System.out.println(teststring + " Match alt");
		}
		else {
			System.out.println(teststring + " Geen Match alt ");
		}

	}

}
