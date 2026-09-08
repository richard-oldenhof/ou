package stack;


public class ArrayStack<E> implements Stack<E> {
	public static final int CAPICITY = 1000;
	private E[] data;
	private int size ;
	
	
	
	public ArrayStack(int capacity) {
		this.size=-1;
		data = (E[]) new Object[capacity];
	}
	
	public ArrayStack() {
		this(CAPICITY);
	}
	
	public int size() {	
		return this.size+1;	
	}
	
	public boolean isEmpty() {
		return size==-1;
	}
	public void push(E e) {	
		if (size < data.length-1) {
			size++;
			data[size] = e;		
		}
	} 
	
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return this.data[this.size];
	}
	
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer= data[size];
		data[size]=null;
		size--;
		return answer;
		
	}
	

}
