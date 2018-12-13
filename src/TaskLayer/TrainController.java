package TaskLayer;

import java.util.List;

import DataSource.DataHandler;
import DataSource.FileHandler;
import Domain.Train;
import Domain.trainPart.TrainPart;
import Domain.trainPart.TrainPartFactory;

public class TrainController {
	private DataHandler dh = new FileHandler();

	// new train
	public Train createTrain(String code) {
		Train t1 = new Train(code);
		System.out.println("train is added to the file mysave.txt");
		return t1;
	}

	public void AddTrainPart(String trainCode, String type) {
		Train t = selectTrain(trainCode);
		TrainPartFactory tpf = new TrainPartFactory();
		TrainPart trainpart = tpf.makeTrainPart(type);
		t.addParts(trainpart);
		dh.editTrain(trainCode, t);

	}

	public void delTrainPart(String trainCode, int index) {
		index -= 1;
		Train t = selectTrain(trainCode);
		if (t != null) {
			t.delParts(index);
			dh.editTrain(trainCode, t);
		}
		System.out.println("is deleted successfully");

	}

	public List selectAllTrainCodes() {
		return dh.selectAllTrainCodes();
	}

	public Train selectTrain(String trainCode) {
		Train t = dh.selectTrain(trainCode);
		return t;
	}

	public void delTrain(String trainCode) {
		dh.deleteTrain(trainCode);

	}

}
