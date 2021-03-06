package TaskLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DataSource.DataHandler;
import DataSource.FileHandler;
import Domain.Train;
import Domain.trainPart.TrainPart;
import Domain.trainPart.TrainPartFactory;
import Domain.trainPart.TrainPartType;

public class TrainController {
	private DataHandler dh = new FileHandler();

	// new train
	public Train createTrain(String code) {
		Train t1 = new Train(code);
		return t1;
	}

	public void AddTrainPart(String trainCode, String type) {
		Train t = selectTrain(trainCode);
		TrainPartFactory tpf = new TrainPartFactory();
		TrainPart trainpart = tpf.makeTrainPart(type);
		t.addParts(trainpart);
		dh.editTrain(trainCode, t);

	}

	public void delTrainPart(String trainCode, String part) {
//		index -= 1;
		Train t = selectTrain(trainCode);
		if (t != null) {
			t.delParts(part);
			dh.editTrain(trainCode, t);
		}
		System.out.println("is deleted successfully");

	}

	public List<String> selectAllTrainCodes() {
		return dh.selectAllTrainCodes();
	}

	public Train selectTrain(String trainCode) {
		Train t = dh.selectTrain(trainCode);
		return t;
	}

	public void delTrain(String trainCode) {
		dh.deleteTrain(trainCode);

	}
	
	public int selectZitplaatsen(String code) throws FileNotFoundException, IOException {
		List<TrainPartType> tpt = dh.selectAllTypesFromTrain(code);
		int i = 0;
		for (TrainPartType tptt : tpt ) {
			i += tptt.getZitPlaatsen();
		} 
		return i;
	}


}
