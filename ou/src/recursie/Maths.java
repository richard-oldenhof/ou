package recursie;

public final  class Maths {
	public static int faculteit(int n) {
		if (n < 0) { 
			return -1;
		}
		if (n == 0) {
			return 1;
		}
		return n*faculteit(n-1);
	}
	
	public static double  power (double x , int n) {
		if (n<0) {
			return 0.0; // eigenlijk foutmelding or exception 
		}
		if (n==0) {
			return 1;
		}
		return x*power(x , n-1);
	}

}
