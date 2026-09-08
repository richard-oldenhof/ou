package list;

public class TestDoubleLinkedList {

	public static void main(String[] args) {
		
				System.out.println("Begin");
				DoubleLinkedList<String> lijst = new DoubleLinkedList();
				lijst.addFirst("A");
				System.out.println("first: " + lijst.first());
				System.out.println("last: " + lijst.last());
				lijst.addFirst("B");
				System.out.println("first: " + lijst.first());
				System.out.println("last: " + lijst.last());
				lijst.addlast("CC");
				System.out.println("first: " + lijst.first());
				System.out.println("last: " + lijst.last());
				lijst.addlast("DD");
				System.out.println("first: " + lijst.first());
				System.out.println("last: " + lijst.last());
				lijst.addFirst("Y");
				System.out.println("first: " + lijst.first());
				System.out.println("last: " + lijst.last());
				lijst.removeFirst();
				lijst.removeLast();
				System.out.println("first: " + lijst.first());
				System.out.println("last: " + lijst.last());
				//System.out.println(lijst.printList());
				System.out.println("Einde");

	}

}
