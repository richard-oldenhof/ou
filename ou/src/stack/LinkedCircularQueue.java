package stack;

import list.DoubleList;
import list.SingleList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
	private int sz = 0;
	private int f =0;
	private DoubleList<E> queue = new DoubleList();
	public int size() {
		return this.sz;
	}
	
	public boolean isEmpty() {
		return sz == 0;
	}
	
	public E first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			// uitwerken first teruggeven
			return queue.first();
		}
	}
	
	public void enQueue(E e) {	
			// uitwerken enqueue;
		queue.addlast(e);;
    	sz++;				
	}
	
	public E deQueue() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			sz--;
			return queue.removeFirst();
		}
	}
	public void rotate() {
		queue.rotate();	
	}

}
