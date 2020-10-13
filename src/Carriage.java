import java.util.HashMap;


public class Carriage {
	private final int SEATS_NUM = 2;
	private int number;
	private HashMap<Integer, Integer> seats;

	public Carriage() {
		this.number = 1;
		this.seats = new HashMap<Integer, Integer>();
		for (int i = 0; i < SEATS_NUM; i++) {
			this.seats.put(i+1, -1);
		}
	}
	public void initializeCarriage(int oldNumber) {
		this.number= oldNumber+1;
		for (int i = 0; i < SEATS_NUM; i++) {
			this.seats.put(i+1, -1);
		}
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public HashMap<Integer, Integer> getSeats() {
		return seats;
	}
	public void setSeats(HashMap<Integer, Integer> seats) {
		this.seats = seats;
	}
	public void showSeats() {
		for (Integer key: this.seats.keySet()) {
			System.out.println("seat-key: "+key+" id: "+this.seats.get(key));
		}
	}
	@Override
	public String toString() {
		return "Carriage [SEATS_NUM=" + SEATS_NUM + ", number=" + number + ", seats=" + seats + "]";
	}

	
	
}
