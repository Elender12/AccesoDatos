import java.util.HashMap;


public class Carriage {
	private final int SEATS_NUM = 10;
	private int number;
	private HashMap<Integer, Integer> seats;

	public Carriage(int number) {
		this.number = number;
		this.seats = new HashMap<Integer, Integer>();
		
	}
	public void initializeCarriage() {
		for (int i = 0; i < SEATS_NUM; i++) {
			this.seats.put(i+1, -1);
		}
	}
	
}
