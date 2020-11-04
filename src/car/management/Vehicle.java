package car.management;

import java.io.Serializable;

public abstract class Vehicle implements Serializable{
	private String licensePlate;
	private int wheelsNum;
	
	
	public Vehicle(String licensePlate, int wheelsNum) {
		this.licensePlate = licensePlate;
		this.wheelsNum = wheelsNum;
	}

	public abstract String turnOn();

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getWheelsNum() {
		return wheelsNum;
	}

	public void setWheelsNum(int wheelsNum) {
		this.wheelsNum = wheelsNum;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", wheelsNum=" + wheelsNum + "]";
	}

	
	
}
