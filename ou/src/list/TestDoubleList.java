package list;

public class TestDoubleList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Begin");
		DoubleList<String> lijst = new DoubleList();
		System.out.println(lijst.printList());
		lijst.addFirst("A");
		System.out.println(lijst.printList());
		lijst.addFirst("B");
		System.out.println(lijst.printList());
		lijst.addlast("CC");
		System.out.println(lijst.printList());
		lijst.addlast("DD");
		System.out.println(lijst.printList());
		lijst.addFirst("Y");
		System.out.println(lijst.printList());
		lijst.addFirst("T");
		System.out.println(lijst.printList());
		System.out.println("Removefirst: " + lijst.removeFirst());
		System.out.println("Removefirst: " + lijst.removeFirst());
		System.out.println("Removefirst: " + lijst.removeFirst());
		System.out.println("Removefirst: " + lijst.removeFirst());
		System.out.println("Removefirst: " + lijst.removeFirst());
		System.out.println("Removefirst: " + lijst.removeFirst());
		System.out.println("Removefirst: " + lijst.removeFirst());
		//System.out.println(lijst.printList());
		System.out.println("Einde");
	}
}
