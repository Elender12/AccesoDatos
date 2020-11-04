package car.management;

import java.io.Serializable;

public class Moto extends Vehicle implements Serializable {
	private int cilynderCapacity;
	
	
	public Moto(String licensePlate, int wheelsNum, int cilynderCapacity) {
		super(licensePlate, wheelsNum);
		this.cilynderCapacity = cilynderCapacity;
	}


	public int getCilynderCapacity() {
		return cilynderCapacity;
	}


	public void setCilynderCapacity(int cilynderCapacity) {
		this.cilynderCapacity = cilynderCapacity;
	}


	@Override
	public String turnOn() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		return "Moto [cilynderCapacity=" + cilynderCapacity + "]";
	}
	

}
