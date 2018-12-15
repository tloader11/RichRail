package DataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Domain.Train;
import Domain.trainPart.TrainPartType;

public interface DataHandler {
	public void addTrain(Train t);

	public void editTrain(String oldTraincode, Train newTrain);

	public void deleteTrain(String trainCode);

	public Train selectTrain(String trainName);

	public List selectAllTrainCodes();

	public void addRollerType(String type, int zitPlaatsen);

	public List selectAllTypes();

	public void delType(String type);
	
	public List<TrainPartType> selectAllTypesFromTrain(String code) throws FileNotFoundException, IOException;
	
	public TrainPartType selectType(String code) throws FileNotFoundException, IOException;

}
