import java.time.LocalDate;
import java.util.ArrayList;

public class TicketsSale {

	public static void main(String[] args) {
		// para comprar billetes se debe utilizar un hashmap
		//hash map con día y trenes
		//meter billete vendido en el hash y en un arraylist (comparator)
		Train trainAVE = new Train(1,"08:00","Delicias","Atocha");
		Train trainRegional = new Train(2,"09:00","Delicias","Barcelona-Saints");
		Train trainSuper = new Train(1,"08:00","Delicias","Salamanca-Todos");
		ArrayList<Ticket> ticketsBackUp = new ArrayList<Ticket>();
		trainAVE.getCarriages().initializeCarriage();

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
			//show trains
			System.out.println(trainAVE.toString());
			//ask for train
			//generate the ticket
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
