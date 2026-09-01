package list;

public class SingleList<E> {
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
	private Node<E> head;
	private Node<E> tail;
	
	public SingleList() {
		this.size=0;
		this.head=null;
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
			return head.getElement();
		}
		else {
			return null;
		}
	}
	
	public E last() {
		if (!(tail==null)) {
			return tail.getElement();
		}
		else {
			return null;
		}		
	}
	 public void addFirst(E element) {
		Node<E> item = new Node(element,null);
		this.size++;
		if (this.head == null) {
			head =item;
			tail=item;
		}
		else {
			item.setNext(head);
			head=item;
		}
	 }
	 
	 public E removeFirst() {
		if (head==null) {
			return null;
		}
		E element = head.getElement();
		head=head.getNext();
		if (head==null) {
			tail=null;
		}
		this.size--;
		return element;
	 }
	 
	 public void addlast (E element) {
		 Node<E> item = new Node(element,null);
		 if (head == null) { 
			 head=item;
			 tail=item;
			 
		 }
		 tail.setNext(item);
		 tail=item;
	 }
	 
	 public String printList() {
		 String result = "";
		 if (this.isEmpty()) {
			 result= "Lijst is leeg";
		 }
		 Node<E> hulpitem = head;
		 while (!(hulpitem == null)) {
			 result=result+hulpitem.getElement();
			 hulpitem=hulpitem.getNext();
		 }
		 return result;
		 
	 }

}
 