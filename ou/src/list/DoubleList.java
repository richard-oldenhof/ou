package list;

import list.SingleList;

public class DoubleList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n) {
			this.element = e;
			this.next = n;
		}
		public E getElement() {
			return this.element;
		}
		public Node<E> getNext() {
			return this.next;
		}
		public void setNext(Node<E> n) {
			this.next = n;
		}		
	}
	private int size;
	private Node<E> tail;
	
	public DoubleList() {
		this.size=0;
		this.tail=null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public E first() {
		if (!this.isEmpty()) {
			return tail.getNext().getElement();
		}
		else {
			return null;
		}
	}
	
	public E last() {
		if (!this.isEmpty()) {
			return tail.getElement();
		}
		else {
			return null;
		}		
	}
	 public void addFirst(E element) {
		Node<E> item = new Node(element,null);
		if (this.size == 0) {
			tail=item;
			tail.setNext(item);
		}
		else {
			item.setNext(tail.getNext());
			tail.setNext(item);
			
		}
		this.size++;
	 }
	 
	 public void rotate() {
		 if (!(this.size == 0)) {
			 this.tail= tail.getNext();
		 }
		 
	 }
	 
	 
	 public E removeFirst() {
		if (this.size == 0) {
			return null;
		}
		Node<E> element = tail.getNext();
		if (element == tail) {
			tail = null;

		}
		else {
			tail.setNext(element.getNext());
		}	
		this.size--;
		return element.getElement();
	 }
	 
	 public void addlast (E element) {
		 Node<E> item = new Node(element,null);
		 if (this.size == 0) { 
			 tail=item;
			 tail.setNext(item);
			 
		 }
		 item.setNext(tail.getNext());
		 tail.setNext(item);
		 tail=item;
		 this.size++;
	 }
	 
	 public String printList() {
		 String result = "";
		 if (this.isEmpty()) {
			 result= "Lijst is leeg";
			 return result;
		 }
		 if (tail.getNext() == tail) {
			 return "Lijst bevat 1 element: " + tail.getElement();
		 }
		 Node<E> hulpitem = tail.getNext();
		 while (!(hulpitem == tail)) {	
			 result=result+hulpitem.getElement()+"-";
			 hulpitem=hulpitem.getNext();		 	 
		 }
		 result=result+hulpitem.getElement();
		 return result;	 
	 }
}
