import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TicketsSale {

	public static void main(String[] args) {

		//create trains
		Train trainAVE = new Train(23,"08:00","Delicias","Atocha");
		Train trainRegional = new Train(12,"09:00","Delicias","Barcelona-Saints");
		Train trainSuper = new Train(30,"10:00","Delicias","Salamanca-Todos");
		
		//stores the date with its trains
		HashMap<LocalDate, ArrayList<Train>> timeTable = new HashMap<LocalDate, ArrayList<Train>>(); 
	
		ArrayList<Ticket> ticketsList = new ArrayList<Ticket>();
		
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
		//ask for date
		int day;
		int month;
		int year;
		LocalDate ticketDate = null;
		do {
			switch(option) {
			case 1:
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
				for (Train train : trains) {
					System.out.println(train.toString());
				}
				//ask for train
				int numTrain = Leer.pedirEntero("Insert the number of the train: ");
				Train auxTrain  = new Train();
				for (int i = 0; i < trains.size(); i++) {
					if(trains.get(i).getNumber() == numTrain) {
						auxTrain = trains.get(i);
					}
				}
				if(timeTable.get(ticketDate) == null) {
					timeTable.put(ticketDate, new ArrayList<Train>());
				}
				for (LocalDate date : timeTable.keySet()) {
					if(date.equals(ticketDate) && !timeTable.get(date).contains(auxTrain)){
						timeTable.get(date).add(auxTrain);
					}
					System.out.println(date+" "+timeTable.get(date));
				}
				//generate the ticket
				int [] ticketData =   auxTrain.occupySeat();
				Ticket ticket = new Ticket(ticketData[1], ticketDate, auxTrain.getNumber(), 
						ticketData[2], ticketData[0]);
				ticketsList.add(ticket);
				//showTickets(ticketsList);
				break;
			case 2:
				//look for the ticket and delete it
				Ticket ticketToDelete = new Ticket();
				int ticketId = Leer.pedirEntero("Insert ticket number");
				for (int i = 0; i < ticketsList.size(); i++) {
					if(ticketsList.get(i).getId() == ticketId) {
						ticketToDelete= ticketsList.get(i);
					}
				}
				ArrayList <Train> dateTrainList= timeTable.get(ticketToDelete.getDate());
				boolean deleted = false;
				for (int i = 0; i < dateTrainList.size(); i++) {
					if(dateTrainList.get(i).getNumber() == ticketToDelete.getTrainNum()) {
						 deleted = ticketToDelete.deleteTicket(dateTrainList.get(i), ticketToDelete.getCarriageNum());
					}
				}
				if(deleted) {
					ticketsList.remove(ticketToDelete);
					System.out.println("Your ticket was deleted");
				}else {
					System.out.println("Something went wrong.");
				}
				
				//confirm
				//showTickets(ticketsList);
				break;
			case 3:
				//show options to sort
				Collections.sort(ticketsList, new CompareTicketById());
				for (Ticket item : ticketsList) {
					System.out.println(item.toString());
				}
				Collections.sort(ticketsList, new CompareByDate());
				for (Ticket item : ticketsList) {
					System.out.println(item.toString());
				}
				
				Collections.sort(ticketsList, new CompareByTren());
				for (Ticket item : ticketsList) {
					System.out.println(item.toString());
				}
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
