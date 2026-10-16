package tree;

import java.util.Iterator;

import list.Position;
//import list.LinkedPositionalList.ElementIterator;
//import list.LinkedPositionalList.PositionIterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element =e;
			parent = above;
			left = leftChild;
			right = rightChild;	
		}
		public E getElement() {
			return element;
		}
		public Node<E> getParent() {
			return parent;
		}
		public Node<E> getLeft() {
			return left;
		}
		public Node<E> getRight() {
			return right;
		}
		public void setElement(E e) {
			element=e;
		}
		public void setparent(Node<E> parentNode) {
			parent = parentNode;
		}
		public void setLeft(Node<E> leftChild) {
			left=leftChild;
		}
		public void setRight(Node<E> rightChild) {
			right=rightChild;
		}
	}
	 
	protected Node<E> createNode (E e, Node<E> parentNode, Node<E> left, Node<E> right) {
		return new Node(e, parentNode,left,right);
	}
	
	protected Node<E> root=null;
	private int size = 0;
	
	public LinkedBinaryTree() {
	}
	
	protected Node<E> validate(Position p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("geen valide position type");
		}
		Node<E> node = (Node<E>) p;
		if (node.getParent()== node) {
			throw new IllegalArgumentException("p niet langer in tree");
		}
		return node;		
	}
	
	
	
	
	
	
	public int size() {
		return size;
	}
	
	public Position<E> root() {
		return root;
	}
	
	public Position<E> parent(Position p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	public Position<E> left(Position p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	public Position<E> right(Position p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not empty") ;
		}
		root = createNode(e,null,null,null);
		size=1;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException ("Left child is not null");
		}
		Node<E> child = createNode(e,parent,null,null);
		parent.setLeft(child);
		size++;
		return child;
	}

	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException ("Right child is not null");
		}
		Node<E> child = createNode(e,parent,null,null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = p.getElement();
		node.setElement(e);
		return e;
	}
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node =validate(p);
		if (isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		size+= t1.size() + t2.size();
		if (!t1.isEmpty()) {
			t1.root.setparent(node);
			node.setLeft(t1.root);
			t1.root=null;
			t1.size =0;
		}
		if (!t2.isEmpty()) {
			t2.root.setparent(node);
			node.setRight(t2.root);
			t2.root=null;
			t2.size =0;
		}
		
	}

	public E remove(Position<E>  p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null) {
			child.setparent(node.getParent());
		}
		if (node==root) {
			root = child;
		}
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			}
			else {
				parent.setRight(child);
			}
		}
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setparent(node);
		return temp;
	}

}
