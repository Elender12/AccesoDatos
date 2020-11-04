package car.management;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileClass {
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private boolean end = false;

	public FileClass(File file, String io) {
		
		if(io.equals("i")) {
			try {
				in = new ObjectInputStream(new FileInputStream(file));
			}catch(IOException e) {
				System.exit(1);
			}
		if(io.equals("o")) {
			try {
				out = new ObjectOutputStream(new FileOutputStream(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			}
			
			}	
			
		}
	}
	
	public Boolean write(Vehicle vehicle) {
		try {
			out.writeObject(vehicle);
			out.flush();
		
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NullPointerException npe) {
			return false;
		}finally {
			System.out.println("here in final");
		}
		return true;
	}
	public Vehicle read() {
		Vehicle vehicle = null;
		try {
			vehicle = (Vehicle) in.readObject();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(EOFException eof) {
			this.end = true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	public boolean isEnd() {
		return end;
	}

	
}
