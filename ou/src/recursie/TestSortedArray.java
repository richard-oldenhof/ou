package recursie;

public class TestSortedArray {

	public static void main(String[] args) {
		int[] a = {10987,20,33,44,55,10,4,55};
		int e = 554;
		if (SortedArray.contains(a,0, a.length -1, e)) {
			System.out.println("Waarde " + e + " Gevonden");
		}
		else {System.out.println("Waarde " + e + " Niet Gevonden");	
		}
		System.out.println("Som = " + SortedArray.sum(a, a.length-1));
		System.out.println("Sombin = " + SortedArray.sumbin(a, 0, a.length-1));
		int[] b = SortedArray.reverse(a,0, a.length-1);
		for (int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		System.out.println("Grootste = " + SortedArray.greatest(a, a.length-1));
		String test  = "ABCDEFG";
		System.out.println("oud: " + test + " nieuwe: " + SortedArray.reverse(test));
		String test2  = "negentien";
		System.out.println("oud: " + test2 + " nieuwe: " + SortedArray.reverse(test2));
	}

}
