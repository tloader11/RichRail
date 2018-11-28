package DataSource;

import Domain.Train;

public interface DataHandler {
	public void addTrain(Train t);
	public void editTrain(Train oldTrain, Train newTrain);
	public void deleteTrain(Train t);
	public void viewTrain(String trainName);
		


}
