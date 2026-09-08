package list;

import list.SingleList;

public class DoubleLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;
		public Node(E e, Node<E> p, Node<E> n) {
			this.element = e;
			this.next = n;
			this.prev=p;
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
		public Node<E> getPrev() {
			return this.prev;
		}
		public void setPrev(Node<E> p) {
			this.prev = p;
		}	
	}
	private int size;
	private Node<E> header;
	private Node<E> trailer;
	public DoubleLinkedList() {
		this.header= new  Node<E>(null,null,null);
		this.trailer= new  Node<E>(null,header,null);
		this.header.setNext(trailer);
		this.size=0;
	}
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public E first() {
		if (this.isEmpty()) {
			return null;
		}
		return header.getNext().getElement();
	}
	
	public E last() {
		if (this.isEmpty()) {
			return null;
		}
		return trailer.getPrev().getElement();
	}
	
	private E addBetween (E element, Node<E> pre ,Node<E> suc) {
		Node<E> node = new Node<E>(element,pre,suc);
		pre.setNext(node);
		suc.setPrev(node);
	    this.size++;
		return element;	
	}
	
	private E remove (Node<E> node) {
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		return node.getElement();
	}
	
	public E addFirst (E element) {
		return addBetween(element,header,header.getNext());
	}
	
	public E addlast (E element) {
		return addBetween(element,trailer.getPrev(),trailer);
	}
	
	public E removeFirst() {
		return remove(header.getNext());
	}
	
	public E removeLast() {
		return remove(trailer.getPrev());
	}
}
