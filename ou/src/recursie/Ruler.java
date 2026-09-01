package recursie;

public class Ruler {
	public void drawRuler(int aantalcentimeter, int maxeenheden) {
		drawLine (maxeenheden);
		drawInterval (maxeenheden -1);
		drawLine (maxeenheden);
	}
	
	public void drawLine (int aantaleenheden) {
		for (int j=1 ;j<= aantaleenheden; j++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	
	public void drawInterval (int maxeenheden) {
		if (maxeenheden >=1) {
			drawInterval ( maxeenheden - 1);
			drawLine (maxeenheden);
			drawInterval ( maxeenheden -1);
			
		}
	}

}
