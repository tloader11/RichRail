package TrainComponenten;

import Domain.Component;

public class Wagon extends Component {

	private int seats;

	public Wagon(String name) {
		super(name, "Wagon");
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
}
