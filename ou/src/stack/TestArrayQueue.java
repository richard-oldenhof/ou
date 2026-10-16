package stack;

public class TestArrayQueue {

	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<String>(4);
		if (queue .isEmpty()) {
			System.out.println("Leeg");
		}
		else {
			System.out.println("Niet Leeg " + queue.size());
		}
		queue.enQueue("eerste");
		queue.enQueue("tweede");
		queue.enQueue("derde");
		System.out.println("first " + queue.first() + " size " + queue.size());
		System.out.println("dequeue " + queue.deQueue() + " size " + queue.size());	
		queue.enQueue("vierde");
		System.out.println("first " + queue.first() + " size " + queue.size());
		System.out.println("dequeue " + queue.deQueue() + " size " + queue.size());	
		System.out.println("dequeue " + queue.deQueue() + " size " + queue.size());	
		System.out.println("dequeue " + queue.deQueue() + " size " + queue.size());	
		System.out.println("dequeue " + queue.deQueue() + " size " + queue.size());	

	}

}
