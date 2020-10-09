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
	public int[] occupySeat() {
		int ticketData[] = new int[2];
		for ( Integer seat : this.seats.keySet()) {
			if(this.seats.get(seat) == -1) {
				this.seats.put(seat, generateId());
				System.out.println("key: "+seat+" "+this.seats.get(seat));
				ticketData[0]= seat;
				ticketData[1]= this.seats.get(seat);
				break;
			}
		
		}
		System.out.println("from carriage:::"+ticketData[0]+" "+ticketData[1]);
		return ticketData;	
	}
	public int generateId() {
		int id = (int) (Math.random() * 200 +1);
		return id;
	}
}
