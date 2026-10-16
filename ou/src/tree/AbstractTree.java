package tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import list.Position;
//import tree.LinkedBinaryTree.ElementIterator;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) {
		return (numChildren(p) > 0);
	}
	public boolean isExternal(Position<E> p) {
		return (numChildren(p) == 0);
	}
	public boolean isRoot(Position<E> p) {
		return (p ==  root());
	}
	public boolean isEmpty() {
		return (size() == 0);
	}
	public int depth(Position<E> p) {
		if (isRoot(p)) {
			return 0;
		}
		return 1 + depth(parent(p));
	}
	private int heightBad() {
		int h =0;
		for (Position<E> p : positions()) {
			if (isExternal(p)) {
				h = Math.max(h, depth(p));
			}
		}
		return h;
	}
	
	public int heigth(Position<E> p) {
		int h=0;
		for (Position<E> c: children(p)) {
			h=Math.max(h, 1+heigth(c));
		}
		return h;
	}
	
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> poslterator = positions().iterator();
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
	
	
	public Iterable<Position<E>> positions() {
		return preorder();
	}
	
	
	private void preorderSubtree(Position<E> p ,List<Position<E>> snapshot) {
		snapshot.add(p);
		for (Position<E> c :children(p)) {
			preorderSubtree(c,snapshot);
		}
	}
	
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(),snapshot);
		}
		return snapshot;
		
	}
}
