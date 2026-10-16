package tree;

import list.Position;

public class ArrayBinaryTree<E> extends AbstractBinaryTree<E> {
	protected static class Cell<E> implements Position<E> {
		private E element;
		private int index;
        public Cell(E element, int index) {
            this.element = element;
            this.index = index;
        }
        
        public void setElement(E element) { 
    	  this.element = element; 
        }
        
        public void setIndex(int index) { 
      	  this.index = index; 
          }
        public E getElement() {
			if (this.index == -1) throw new IllegalStateException("Position no longer valid");
			return element;
		}
        
        public int getIndex() { 
        	return index; 
        }
        public void invalidate() { 
        	this.index = -1; this.element = null; 	
        }
	}
	
	private static final int DEFAULT_CAPACITY = 15; 
    private Cell<E>[] tree;
    private int size = 0;
	
    
    public ArrayBinaryTree() {
        tree = (Cell<E>[]) new Cell[DEFAULT_CAPACITY];
    }

    public ArrayBinaryTree(int capacity) {
        tree = (Cell<E>[]) new Cell[capacity];
    }

    
    protected Cell<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Cell)) throw new IllegalArgumentException("Not a valid position type");
        Cell<E> cell = (Cell<E>) p;
        if (cell.getIndex() == -1 || cell.getIndex() >= tree.length || tree[cell.getIndex()] != cell) {
            throw new IllegalArgumentException("Position is invalid or no longer in tree");
        }
        return cell;
    }

    /** Dynamically resizes the underlying array when formulas exceed bounds */
    @SuppressWarnings("unchecked")
    protected void resize(int minCapacity) {
        int newCapacity = Math.max(tree.length * 2, minCapacity);
        Cell<E>[] temp = (Cell<E>[]) new Cell[newCapacity];
        System.arraycopy(tree, 0, temp, 0, tree.length);
        tree = temp;
    }
    
    
    
	public Position<E> root() {
		return  tree[0];
	}
	
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Cell<E> cell = validate(p);
        int i = cell.getIndex();
        if (i == 0) return null; // Root has no parent
        return tree[(i - 1) / 2];
	}
	
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Cell<E> cell = validate(p);
        int rightIdx = 2 * cell.getIndex() + 2;
        if (rightIdx >= tree.length) return null;
        return tree[rightIdx];
	}
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Cell<E> cell = validate(p);
        int leftIdx = 2 * cell.getIndex() + 1;
        if (leftIdx >= tree.length) return null;
        return tree[leftIdx];
	}
	
	public int size() {
		return size;
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        tree[0] = new Cell<>(e, 0);
        size = 1;
        return tree[0];
    }
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Cell<E> parentCell = validate(p);
        int leftIdx = 2 * parentCell.getIndex() + 1;
        if (leftIdx >= tree.length) resize(leftIdx + 1);
        if (tree[leftIdx] != null) throw new IllegalArgumentException("Left child already exists");
        
        tree[leftIdx] = new Cell<>(e, leftIdx);
        size++;
        return tree[leftIdx];
    }
	
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Cell<E> parentCell = validate(p);
        int rightIdx = 2 * parentCell.getIndex() + 2;
        if (rightIdx >= tree.length) resize(rightIdx + 1);
        if (tree[rightIdx] != null) throw new IllegalArgumentException("Right child already exists");
        
        tree[rightIdx] = new Cell<>(e, rightIdx);
        size++;
        return tree[rightIdx];
    }
	
	public E set(Position<E> p, E e) throws IllegalArgumentException {
        Cell<E> cell = validate(p);
        E old = cell.getElement();
        cell.setElement(e);
        return old;
    }
	
	public E remove(Position<E> p) throws IllegalArgumentException {
        Cell<E> cell = validate(p);
        if (numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
        
        Position<E> child = (left(p) != null ? left(p) : right(p));
        int cellIdx = cell.getIndex();
        E oldElement = cell.getElement();

        if (child != null) {
            Cell<E> childCell = validate(child);
            // In an array-tree implementation, structural modifications require shifting items
            moveSubtree(childCell.getIndex(), cellIdx);
        } else {
            tree[cellIdx] = null;
        }

        cell.invalidate();
        size--;
        return oldElement;
    }
	
	private void moveSubtree(int oldRootIdx, int newRootIdx) {
        if (oldRootIdx >= tree.length || tree[oldRootIdx] == null) return;
        
        Cell<E> cell = tree[oldRootIdx];
        cell.index = newRootIdx;
        tree[newRootIdx] = cell;
        tree[oldRootIdx] = null;

        // Shift left and right descendants down recursively
        moveSubtree(2 * oldRootIdx + 1, 2 * newRootIdx + 1);
        moveSubtree(2 * oldRootIdx + 2, 2 * newRootIdx + 2);
    }


}
