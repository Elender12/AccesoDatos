import java.util.Comparator;

public class CompareByDate implements Comparator<Ticket>  {

	@Override
	public int compare(Ticket ticket1, Ticket ticket2) {
		// TODO Auto-generated method stub
		return ticket1.getDate().compareTo(ticket2.getDate());
	}


}
