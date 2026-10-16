package list;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<String> lijst = new  ArrayList(1);
		System.out.println("begin test");
		lijst.add(0, "eerste");
		lijst.add(1, "tweede");
		lijst.add(2, "derde");
		for (int index = 0;index <= lijst.size()-1;index++) {
			System.out.println("element " + index + " "  + lijst.get(index));
		}
		lijst.remove(3);
		for (int index = 0;index <= lijst.size()-1;index++) {
			System.out.println("element " + index + " "  + lijst.get(index));
		}
		lijst.remove(0);
		lijst.remove(0);
		lijst.remove(0);
		lijst.remove(0);
		for (int index = 0;index <= lijst.size()-1;index++) {
			System.out.println("element " + index + " "  + lijst.get(index));
		}
		System.out.println("eind test");

	}

}
