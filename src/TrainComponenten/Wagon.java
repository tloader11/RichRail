package TrainComponenten;

import Domain.Component;

public class Wagon extends Component {

	private int seats;

	public Wagon() {
		super();
		super.type = "Wagon";
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
}
