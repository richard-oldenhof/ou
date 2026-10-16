package stack;

import list.SingleList;

public class LinkedQueue<E> implements Queue<E> {
	private int sz = 0;
	private int f =0;
	private SingleList<E> queue = new SingleList();
	
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

}
