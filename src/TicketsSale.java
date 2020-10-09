import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketsSale {

	public static void main(String[] args) {
		// para comprar billetes se debe utilizar un hashmap
		//hash map con día y trenes
		//meter billete vendido en el hash y en un arraylist (comparator)
		Train trainAVE = new Train(1,"08:00","Delicias","Atocha");
		Train trainRegional = new Train(2,"09:00","Delicias","Barcelona-Saints");
		Train trainSuper = new Train(3,"10:00","Delicias","Salamanca-Todos");
		HashMap<LocalDate, ArrayList<Train>> timeTable = new HashMap<LocalDate, ArrayList<Train>>(); 
		ArrayList<Ticket> ticketsBackUp = new ArrayList<Ticket>();
		trainAVE.getCarriages().initializeCarriage();
		ArrayList<Train> trains = new ArrayList<Train>();
		trains.add(trainAVE);
		trains.add(trainRegional);
		trains.add(trainSuper);
		
		System.out.println("1. Buy a ticket.");
		System.out.println("2. Return a ticket.");
		System.out.println("3. Order tickets.");
		int option = Leer.pedirEntero("Choose a option, please: ");
		switch(option) {
		case 1:
			//ask for date
//			int day = Leer.pedirEntero("Insert the day: ");
//			int month= Leer.pedirEntero("Insert the month");
//			int year = Leer.pedirEntero("Insert the year");
//			LocalDate ticketDate = LocalDate.of(year, month, day); 
			LocalDate ticketDate = LocalDate.of(2020, 10, 9); 
			//show trains
			for (int i = 0; i < trains.size(); i++) {
				System.out.println(trains.get(i).toString());
				
			}
			//ask for train
			int numTrain = Leer.pedirEntero("Insert the number of the train: ");
			//generate the ticket
			//LocalDate date, Train train, Carriage carriage, String seat, float price)
			//Ticket ticket = new Ticket(ticketDate, trains.get(numTrain), trains.get(numTrain).getCarriages() );
			int [] ticketData = trainAVE.getCarriages().occupySeat();
			System.out.println("//");
			
			System.out.println(ticketData[0]+" "+ticketData[1]);
			//(int id, LocalDate date, int trainNum, int carriageNum, int seat, float price)
			Ticket ticket = new Ticket(ticketData[1], ticketDate, trains.get(numTrain-1).getNumber(), 
					trains.get(numTrain).getCarriages().getNumber(), ticketData[0]);
			System.out.println(ticket.toString());
			break;
		case 2:
			//ask for the date
			//look for the ticket and delete it
			//confirm
			break;
		case 3:
			//show options to order
			//ask for the options
			//show the ordered tickets
			break;
		
		}
	}

}
