package stack;

public class Josephus {
	

	public static void main(String[] args) {
		int aantal  = 3;
		int k = 2;
		int teller = 1;
		LinkedCircularQueue<String> cirkel = new LinkedCircularQueue();
		for (int i =1 ; i<=aantal ; i++) {
			cirkel.enQueue("Speler"+ i);
		}
		while (!(cirkel.isEmpty())) {
			if ((teller % k)==0) {
				System.out.println("naam eruit" + cirkel.deQueue());
			}
			else {
				System.out.println("voor rotate" + cirkel.first());
				cirkel.rotate();
				System.out.println("na rotate " + cirkel.first());
			}
			teller++;
		}
		System.out.println("einde");

	}

}
