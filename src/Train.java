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
			System.out.println("Voy a mirar carriage: " + currentCarriage.toString());
			for (Integer seat : currentCarriage.getSeats().keySet()) {
				System.out.println(
						"estoy mirando el asiento:::" + seat + " con id: " + currentCarriage.getSeats().get(seat));
				if (currentCarriage.getSeats().get(seat).intValue() == -1) {
					System.out.println("LIBRE");
					currentCarriage.getSeats().put(seat, generateId());
					ticketData[0] = seat;
					ticketData[1] = currentCarriage.getSeats().get(seat);
					ticketData[2]= currentCarriage.getNumber();
					System.out.println("ticketData asiento " + ticketData[0] + " id:" + ticketData[1]);
					occupied = true;
					break;
				}
			}
			System.out.println("valor de occupied: " + occupied);
			if (occupied)
				break;
		}
			if (ticketData[0] == 0){
				System.out.println("deberia entrar aqui SOLO SI no encontró nada arriba");
				Carriage aux = new Carriage();
				aux.initializeCarriage(this.carriages.get(this.carriages.size()-1).getNumber());
				this.carriages.add(aux);
				Carriage curCarriage = this.carriages.get(this.carriages.size()-1);
				for ( Integer seat1 : aux.getSeats().keySet()) {
					if(curCarriage.getSeats().get(seat1) == -1) {
						curCarriage.getSeats().put(seat1, generateId());
						//System.out.println("seat is: "+seat1);
						ticketData[0]= seat1;
						ticketData[1]= curCarriage.getSeats().get(seat1);
						ticketData[2]= curCarriage.getNumber();
						break;
					}
				}
			}
		System.out.println("datos antes del return "+ticketData[0]+" ::"+ticketData[1]);
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
