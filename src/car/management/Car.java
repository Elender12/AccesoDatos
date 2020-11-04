package car.management;

import java.io.Serializable;

public class Car  extends Vehicle implements Serializable{
	private int seats;
	
	
	public Car(String licensePlate, int wheelsNum, int seats) {
		super(licensePlate, wheelsNum);
		this.seats = seats;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	@Override
	public String turnOn() {
		return "I'm on bb";
	}


	@Override
	public String toString() {
		return "Car [seats=" + seats + "]";
	}
	


}
