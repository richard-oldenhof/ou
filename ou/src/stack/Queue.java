package stack;

public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enQueue(E e);
	E first();
	E deQueue();
}
