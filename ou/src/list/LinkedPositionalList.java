package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E>  implements PositionallList<E> , java.lang.Iterable<E> {
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node (Node<E> p, Node<E> n, E e) {
			element = e;
			prev = p;
			next = n;
		}
		public E getElement() throws IllegalStateException {
			if (next == null) {
				throw new IllegalStateException("Positie niet valide");
			}
			return element;
		}
		public Node<E> getPrev() {
			return prev;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setPrev(Node<E> p) {
			prev=p;
		}
		public void setNext(Node<E> n) {
			next=n;
		}
		public void setElement(E e) {
			element=e;
		}
	}
	
	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor = first();
		private Position<E> recent = null;
		public boolean hasNext() {
			return (cursor != null);
		}
		public Position<E> next() throws NoSuchElementException {
			if (cursor == null ) {
				throw new NoSuchElementException("Nothing left");
			}
			recent =  cursor;
			cursor=after(cursor);
			return recent;
		}
		public void remove() throws IllegalStateException {
			if (recent==null) {
				throw new IllegalStateException("Nothing to remove");
			}
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}	
	}
	
	private class PositionIterable implements Iterable<Position<E>> {
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}
	
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}
	
	
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> poslterator = new PositionIterator();
		public boolean hasNext() {
			return poslterator.hasNext();
		}
		public E next() {
			return poslterator.next().getElement();
		}
		public void remove() {
			poslterator.remove();
		}
	}
	
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	private int size=0;
	private Node<E> header;
	private Node<E> trailer;
	
	public LinkedPositionalList() {
		header = new Node<>(null,null,null);
		trailer = new Node<>(header, null, null);
		header.setNext(trailer);
	}
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalide p");
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null) {
			throw new IllegalArgumentException("p is geen element");
		}
		return node;
	}
	
	private Position<E> position(Node<E> node) {
		if (node==header||node==trailer) {
			return null;
		}
		return node;
	}
	
	private Position<E> addBetween(E e, Node<E> prev , Node<E> succ) {
		Node<E> newest = new Node<E>(prev,succ ,e);
		prev.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;	
	}
	
    public int size() {
    	return size;
    };
	
	public boolean isEmpty() {
		return (size==0);
	};
	
	public Position<E> first() {
		return position(header.getNext());
	};
	
	public Position<E> last() {
		return position(trailer.getPrev());
	};
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
	};
	
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	};
	
	public Position<E> addFirst(E e) {
		return addBetween(e,header,header.getNext());
	};
	
	public Position<E> addLast(E e) {
		return addBetween(e,trailer.getPrev(),trailer);
	};
	
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		return addBetween(e,validate(p).getPrev(),validate(p));
	};
	
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		return addBetween(e,validate(p),validate(p).getNext() );
	};
	
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
		
	};
	
	public Position<E> remove(Position<E> p) throws IllegalArgumentException {
		validate(p).getPrev().setNext(validate(p).getNext());
		validate(p).getNext().setPrev(validate(p).getPrev());
		size--;
		return p;
	};

}
