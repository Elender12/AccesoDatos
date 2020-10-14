import java.util.Comparator;

public class CompareTicketById implements Comparator<Ticket>  {

	@Override
	public int compare(Ticket ticket1, Ticket ticket2) {
		// TODO Auto-generated method stub
		return ticket1.getId()-ticket2.getId();
	}

}
