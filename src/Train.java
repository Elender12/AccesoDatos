import java.util.ArrayList;

public class Train {
	//attributes
	private int number;
	private String departureTime;
	private String departureStation;
	private String arrivalStation;
	private ArrayList<Carriage> carriages;
	
	
	//constructors
	public Train() {
		
	}
	
	public Train(int number, String departureTime, String departureStation, String arrivalStation) {
		this.number = number;
		this.departureTime = departureTime;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.carriages = new ArrayList<Carriage>();
		//first carriage 
		this.carriages.add(new Carriage());
		
	}

	//getters and setters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public ArrayList<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(ArrayList<Carriage> carriages) {
		this.carriages = carriages;
	}

	public int[] occupySeat() {
		int ticketData[] = new int[3];
		boolean occupied = false;
		for (Carriage currentCarriage : carriages) {
			for (Integer seat : currentCarriage.getSeats().keySet()) {
				if (currentCarriage.getSeats().get(seat).intValue() == -1) {
					currentCarriage.getSeats().put(seat, generateId());
					ticketData[0] = seat;
					ticketData[1] = currentCarriage.getSeats().get(seat);
					ticketData[2]= currentCarriage.getNumber();
					occupied = true;
					break;
				}
			}
			if (occupied)
				break;
		}
			if (ticketData[0] == 0){
				Carriage aux = new Carriage();
				aux.initializeCarriage(this.carriages.get(this.carriages.size()-1).getNumber());
				this.carriages.add(aux);
				Carriage curCarriage = this.carriages.get(this.carriages.size()-1);
				for ( Integer seat1 : aux.getSeats().keySet()) {
					if(curCarriage.getSeats().get(seat1) == -1) {
						curCarriage.getSeats().put(seat1, generateId());
						//seat number
						ticketData[0]= seat1;
						//ticket id
						ticketData[1]= curCarriage.getSeats().get(seat1);
						//carriage number
						ticketData[2]= curCarriage.getNumber();
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
	
	@Override
	public String toString() {
		return "Train " + number + " departures at " + departureTime + "h. from " + departureStation
				+ " station and arrives to " + arrivalStation+".";
	}
}
