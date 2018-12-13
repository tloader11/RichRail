package DataSource;

import java.util.List;

import Domain.Train;

public interface DataHandler {
	public void addTrain(Train t);

	public void editTrain(String oldTraincode, Train newTrain);

	public void deleteTrain(String trainCode);

	public Train selectTrain(String trainName);

	public List selectAllTrainCodes();

	public void addRollerType(String type, int zitPlaatsen);

	public List selectAllTypes();

	public void delType(String type);

}
