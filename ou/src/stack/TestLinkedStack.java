package stack;

public class TestLinkedStack {

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack();
		System.out.println("Size: " + stack.size());
		if (stack.isEmpty()) {
			System.out.println("Stack is leeg");
		}
		else {
			System.out.println("Stack is niet leeg");
		}
		System.out.println("Stacktop: " + stack.top());
		stack.push("A");
		System.out.println("Stacktop: " + stack.top());
		System.out.println("Stackpop: " + stack.pop());
		if (stack.isEmpty()) {
			System.out.println("Stack is leeg");
		}
		else {
			System.out.println("Stack is niet leeg");
		}
		stack.push("B");
		stack.push("C");
		System.out.println("Size: " + stack.size());
		System.out.println("Stacktop: " + stack.top());
		stack.push("D");
		stack.push("E");
		System.out.println("Stacktop: " + stack.top());
		stack.push("F");
		System.out.println("Stacktop: " + stack.top());
		stack.push("y");
		System.out.println("Stacktop: " + stack.top());
		stack.push("z");
		System.out.println("Stacktop: " + stack.top());
		System.out.println("Size: " + stack.size());
		stack.push("q");
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());
		System.out.println("Stackpop: " + stack.pop());

	}

}
