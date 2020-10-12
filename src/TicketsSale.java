import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketsSale {

	public static void main(String[] args) {
		// para comprar billetes se debe utilizar un hashmap
		//hash map con día y trenes
		//meter billete vendido en el hash y en un arraylist (comparator)
		
		//create trains
		Train trainAVE = new Train(1,"08:00","Delicias","Atocha");
		Train trainRegional = new Train(2,"09:00","Delicias","Barcelona-Saints");
		Train trainSuper = new Train(3,"10:00","Delicias","Salamanca-Todos");
		
		//stores the date with its trains
		HashMap<LocalDate, ArrayList<Train>> timeTable = new HashMap<LocalDate, ArrayList<Train>>(); 
	
		ArrayList<Ticket> ticketsList = new ArrayList<Ticket>();
		
		ArrayList<Train> dailyTrains = new ArrayList<Train>();
		
		//initialize all carriages
//		trainAVE.getCarriages().initializeCarriage();
//		trainRegional.getCarriages().initializeCarriage();
//		trainSuper.getCarriages().initializeCarriage();
		
		//general list of trains
		ArrayList<Train> trains = new ArrayList<Train>();
		trains.add(trainAVE);
		trains.add(trainRegional);
		trains.add(trainSuper);
		
		//user's options
		System.out.println("1. Buy a ticket.");
		System.out.println("2. Return a ticket.");
		System.out.println("3. Order tickets.");
		int option = Leer.pedirEntero("Choose a option, please: ");
		do {
			switch(option) {
			case 1:
				//ask for date
				int day;
				int month;
				int year;
				LocalDate ticketDate = null;
				try {
					day = Leer.pedirEntero("Insert the day: ");
					month= Leer.pedirEntero("Insert the month: ");
					year = Leer.pedirEntero("Insert the year: ");
					ticketDate = LocalDate.of(year, month, day); 
				}catch(DateTimeException dt ) {
					System.out.println("Incorrect date.");
					ticketDate= LocalDate.now();
				}
			
				//show trains
			
				//ask for train
				int numTrain = Leer.pedirEntero("Insert the number of the train: ");
				if(timeTable.get(ticketDate) == null) {
					timeTable.put(ticketDate, new ArrayList<Train>());
				}
				Train auxTrain = trains.get(numTrain-1);
				for (LocalDate date : timeTable.keySet()) {
					if(date.equals(ticketDate) && !timeTable.get(date).contains(auxTrain)){
						timeTable.get(date).add(trains.get(numTrain-1));
					}
					System.out.println(date+" "+timeTable.get(date));
				}
				//generate the ticket
				int [] ticketData = trains.get(numTrain-1).getCarriages().occupySeat();
				Ticket ticket = new Ticket(ticketData[1], ticketDate, trains.get(numTrain-1).getNumber(), 
						trains.get(numTrain-1).getCarriages().getNumber(), ticketData[0]);
		
				ticketsList.add(ticket);
//				for (LocalDate i : timeTable.keySet()) {
//					System.out.println(i+" "+timeTable.get(i));
//				}
				showTickets(ticketsList);
				break;
			case 2:
				//ask for the date
				//look for the ticket and delete it
				//confirm
				break;
			case 3:
				//show options to sort
				//o número de billete: datos de billetes (de billetes) o fecha, tren, vagón y asiento: 
				//(este puede salir del mapa con clave la fecha y valor que puede ser el billete).
				//o tren, fecha, vagón : asientos vendidos (de billetes)
				//ask for the options
				//show the sorted tickets
				break;
			
			}
			option = Leer.pedirEntero("Choose a option, please: ");
		}while(option !=4);
	
	}
	public static void showTrainInfo(ArrayList<Train> trains) {
		for (int i = 0; i < trains.size(); i++) {
			
			System.out.println(trains.get(i).toString());
		}
	}
	public static void showTickets(ArrayList<Ticket> tickets) {
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(tickets.get(i));
			
		}
	}
}
