package car.management;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("Gelou?");
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Vehicle> vehiclesFromFile = new ArrayList<Vehicle>();
		Vehicle car1 = new Car("0822GTT",4, 5);
		Vehicle car2= new Car("3732FSG",4,4);
		vehicles.add(car1);
		vehicles.add(car2);
		
		File file = new File("cars.dat");
	
			if(file.exists()) {
				FileClass fc = new FileClass(file, "o");
				boolean result = fc.write(car1);
				System.out.println(result);
				//fc.write(car2);
			}else {
				System.out.println("There's no file :(");
			}
		
		
		
		
			FileClass file2= new FileClass(file, "i");
			Vehicle veh = file2.read();
			while(!file2.isEnd()) {
				 vehiclesFromFile.add(veh);
				 veh = file2.read();
				
			}
		 
		
		System.out.println("lenght::"+vehiclesFromFile.size());
		for (Vehicle vehicle : vehiclesFromFile) {
			
			if(vehicle instanceof Car) {
				vehicle.toString();
			}else if(vehicle instanceof Moto) {
				vehicle.toString();
				
			}
		}
	
		}
}