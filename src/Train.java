
public class Train {
	//attributes
	private int number;
	private String departureTime;
	private String departureStation;
	private String arrivalStation;
	private Carriage carriages;
	
	
	//constructors
	public Train() {
		
	}
	
	public Train(int number, String departureTime, String departureStation, String arrivalStation) {
		this.number = number;
		this.departureTime = departureTime;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.carriages = new Carriage();
	}

	//getters and setters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public Carriage getCarriages() {
		return carriages;
	}

	public void setCarriages(Carriage carriages) {
		this.carriages = carriages;
	}

	@Override
	public String toString() {
		return "Train " + number + " departures at " + departureTime + "h. from " + departureStation
				+ " station and arrives to " + arrivalStation+".";
	}
	
	
	

}
