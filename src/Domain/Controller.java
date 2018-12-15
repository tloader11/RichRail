package Domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import TaskLayer.TrainController;
import TaskLayer.TrainPartController;

public class Controller {
	private TrainController tc = new TrainController();
	private TrainPartController tpc = new TrainPartController();

	public Controller() {
		super();
	}

	public boolean create(String name, String type, int numseats) {
		if (type != null && type.equalsIgnoreCase("train")) {
			tc.createTrain(name);
		} else if (type != null && type.equalsIgnoreCase("wagon")) {
			tpc.CreatePartType(name, numseats);
		}
		return true;
	}

	public boolean add(String wagon, String Train) {
		// add wg1 to tr1;

		tc.AddTrainPart(Train, wagon);

		return true;
	}

	// public static boolean save() {
	//
	// return true;
	// }

	public boolean remove(String part, String train) {
		tc.delTrainPart(train, part);
		return true;
	}

	public boolean delete(String name, String type) {
		if (type != null && type.equalsIgnoreCase("train")) {
			tc.delTrain(name);
		} else if (type != null && type.equalsIgnoreCase("wagon")) {
			tpc.delPartType(name);
		}
		
		return true;
	}

	public Train select(String name) {
		return tc.selectTrain(name);
	}
	
	public int getnumseats(String name, String type) throws FileNotFoundException, IOException {
		int seats = 0;
		if (type != null && type.equalsIgnoreCase("train")) {
			seats = tc.selectZitplaatsen(name);
		} else if (type != null && type.equalsIgnoreCase("wagon")) {
			seats = tpc.selectZitplaats(name);
		}
		ConsoleReader.numbseats(name  ,type , seats);
		return seats;
	}

	public List<String> selectAll() {
		return tc.selectAllTrainCodes();
	}

}
