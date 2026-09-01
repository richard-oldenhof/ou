package list;

public class TestSingleList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		SingleList<String> lijst = new SingleList();
		lijst.addFirst("A");
		System.out.println(lijst.printList());
		lijst.addFirst("B");
		System.out.println(lijst.printList());
		lijst.addlast("CC");
		System.out.println(lijst.printList());
		lijst.addlast("DD");
		lijst.addFirst("Y");
		System.out.println(lijst.printList());
		System.out.println("first: " + lijst.first());
		System.out.println("last: " + lijst.last());
		lijst.removeFirst();
		System.out.println(lijst.printList());
	}

}
