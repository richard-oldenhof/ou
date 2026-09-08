package stack;

import list.SingleList;

public class LinkedStack<E> implements Stack<E>  {
	private SingleList<E> list = new SingleList();
	public LinkedStack() {
		list = new SingleList();	
	}
	
	public int size() {
		return this.list.getSize();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void push(E e) {
		list.addFirst(e);
	}
	
	public E top() {
		return list.first();
	}
	
	public E pop() {
		return list.removeFirst();
	}

}
