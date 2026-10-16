package stack;

public class ArrayQueue<E> implements Queue<E>  {
	private E[] data;
	private int sz = 0;
	private int f =0;
	private static final int CAPACITY= 10000;

	public ArrayQueue(int lengte) {
		data = (E[]) new Object[lengte]; 
	}
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	
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
			return data[f];
		}
	}
	
	public void enQueue(E e) {
		if (sz == data.length) {
			// doe niets
		}
		if (sz < data.length) {
			data[ (f+sz) % data.length] = e;
    		sz++;
			
		}
	}
	
	public E deQueue() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			E temp = data[f];
			data[f] = null;
			f =  (f+ 1) % data.length;
			sz--;
			return temp;
		}
	}

}
