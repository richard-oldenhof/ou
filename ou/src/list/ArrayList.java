package list;

public class ArrayList<E> implements List<E> {
	
	private E[] data;
	private int size = 0;
	
	
	public ArrayList(int s) {
		data = (E[]) new Object[s];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public E get(int i) {
		if (0<=i && i<=size-1) {
			return data[i];
		}
		else {
			return null;
		}
	}
	
	public E set(int i, E e) throws IndexOutOfBoundsException {
		E old = data[i];
		data[i] = e;
		return old;
	}
	
	public void add(int i, E e) throws IndexOutOfBoundsException{
		if (size==data.length) {
			resize(2*data.length);
		}
			if (size == 0) {
				data[0] = e;
				size++;
			}
			else {
				for (int index = size; index>i ; index--) {
					data[index]=data[index-1];
				}
				data[i]=e;
				size++;
			}
		
	}
	
	public E remove(int i) throws IndexOutOfBoundsException {
		if (!(size==0) && i<size) {
			E returnvalue = data[i];
			for (int index = i; index < size ; index++) {
				data[index] = data[index+1];
			}		
			size--;
			return returnvalue;
		}
		else {
			return null;
		}
	}
	
	protected void resize(int c) {
		E[] temp = (E[]) new Object[c];
		for (int i=0; i<size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	


}
