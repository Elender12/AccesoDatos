import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Ticket  {
	//attributes
	private int id;
	private LocalDate date;
	private int trainNum;;
	private int carriageNum;
	private int seat;
	private float price;
	
	//constructor
	public Ticket() {

	}
	
	public Ticket(int id, LocalDate date, int trainNum, int carriageNum, int seat) {
		this.id = id;
		this.date = date;
		this.trainNum = trainNum;
		this.carriageNum = carriageNum;
		this.seat = seat;
		this.price = generatePrice();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTrainNum() {
		return trainNum;
	}


	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}


	public int getCarriageNum() {
		return carriageNum;
	}


	public void setCarriageNum(int carriageNum) {
		this.carriageNum = carriageNum;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float generatePrice() {
		float ticketPrice = (float) (Math.random() * 50 + 1);
		return ticketPrice;
	}
	
	public boolean deleteTicket(Train train, int carriageNum) {
		ArrayList<Carriage> carriages = train.getCarriages();
		Carriage currentCarriage = carriages.get(carriageNum-1);
		HashMap<Integer, Integer> seats = currentCarriage.getSeats();
		if(currentCarriage.getNumber() == carriageNum) {
			for ( Integer seat : seats.keySet()) {
				if(seats.get(seat) == this.id && seat == this.seat) {
					train.getCarriages().get(carriageNum-1).showSeats();
					train.getCarriages().get(carriageNum-1).getSeats().put(seat, -1);
					break;
				}
			}
			train.getCarriages().get(carriageNum-1).showSeats();
			
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", date=" + date + ", trainNum=" + trainNum + ", carriageNum=" + carriageNum
				+ ", seat=" + seat + ", price=" + price + "]";
	}

	


}
