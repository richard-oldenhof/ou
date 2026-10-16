package list;

import java.util.Iterator;

public class TestLinkedPositionalList {

	public static void main(String[] args) {
		LinkedPositionalList<String> list = new LinkedPositionalList();
	    list.addFirst("twee");
	    list.addFirst("een");
	    list.addLast("vier");
	    list.addBefore(list.first(), "nul");
	    list.addBefore(list.last(), "3");
		Position<String> cursor = list.first();
		while ( cursor != null) {
			System.out.println("List element : " + cursor.getElement());	
			cursor=list.after(cursor);
		}
		for (Position<String> p: list.positions()) {
			System.out.println("Waarde loop " + p.getElement());
		}
		for (String str: list) {
			System.out.println("Waarde loop list " + str);
		}
	}

}
