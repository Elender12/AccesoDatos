import java.util.Comparator;

public class CompareByTren implements Comparator<Ticket>  {

	@Override
	public int compare(Ticket ticket1, Ticket ticket2) {

		return ticket1.getTrainNum() - ticket2.getTrainNum();
	}

}
