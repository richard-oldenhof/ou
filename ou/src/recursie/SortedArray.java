package recursie;

public final class SortedArray {
	public static boolean contains (int[] a, int s , int t , int e) {
		if (a[s] > e || a[t] < e ) {
			return false;
		};
		
		if (a[s] == e || a[t] == e ) {
			return true;
		};
		
		int middle = s+t/2;
		if (a[middle]<e) {
			return contains(a,middle+1,t,e);
		}
		if (a[middle]>e) {
			return contains(a,s,middle-1,e);
		}
		if (a[middle] == e) {
			return true;
		}
		return false;
		
	}
	
	public static int sum(int[] a , int maxindex) {
		if (maxindex == 0) {
			return a[0];
		}
		return a[maxindex]+sum(a, maxindex -1);
	}
	
	public static int[] reverse (int[] a, int low , int high) {
		if (low < high) {
			int tmp = a[low];
			a[low]=a[high];
			a[high]=tmp;
			reverse (a,low+1,high-1);	
		}		
		return a;
	}
	
	
	public static int sumbin (int[] a , int low , int high ) {
		if (low<high) {
			int middle = (low + high)/2;
			return sumbin(a, low,middle) + sumbin (a, middle + 1 , high);
		}
		return a[low];	
	}
	
	public static int greatest (int []a , int n) {
		if (n==0) {
			return a[0];
		}
		if (a[n] >= greatest(a , n-1)) {
			return a[n];
		}
		else {
			return greatest(a , n-1);
		}
	}
	
	public static String reverse (String s) {
		if (s.length()==1) {
			return s;
		}
		else {
			return   reverse(s.substring(1)) + s.substring(0,1);
		}
	}
	
	

}
