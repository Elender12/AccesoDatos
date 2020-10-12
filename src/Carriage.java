import java.util.HashMap;


public class Carriage {
	private final int SEATS_NUM = 2;
	private int number;
	private HashMap<Integer, Integer> seats;

	public Carriage() {
		this.number = 0;
		this.seats = new HashMap<Integer, Integer>();
		initializeCarriage();
	}
	public void initializeCarriage() {
		this.number += 1;
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
			System.out.println("ticket id is:::"+this.seats.get(seat));
			if(this.seats.get(seat) == -1) {
				this.seats.put(seat, generateId());
				System.out.println("seat is: "+seat);
				ticketData[0]= seat;
				ticketData[1]= this.seats.get(seat);
				break;
			}
		
		}
		if(ticketData[0] == 0) {
			System.out.println("is 0 !!");
			initializeCarriage();
			for ( Integer seat1 : this.seats.keySet()) {
				if(this.seats.get(seat1) == -1) {
					this.seats.put(1, generateId());
					System.out.println("seat is: "+seat1);
					ticketData[0]= seat1;
					ticketData[1]= this.seats.get(seat1);
					break;
				}
			}
		}
		return ticketData;	
	}
	public int generateId() {
		int id = (int) (Math.random() * 200 +1);
		return id;
	}

}
