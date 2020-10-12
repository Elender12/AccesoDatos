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

	@Override
	public String toString() {
		return "Train " + number + " departures at " + departureTime + "h. from " + departureStation
				+ " station and arrives to " + arrivalStation+".";
	}
	
	
	

}
