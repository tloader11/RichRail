package Domain;

import java.awt.Component;

import DataSource.DataHandler;
import DataSource.FileHandler;
import Domain.systemTtrainPart.Wagon;
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
			ConsoleReader.added(type);
		} else if (type != null && type.equalsIgnoreCase("wagon")) {
			tpc.CreatePartType(name, numseats);
			ConsoleReader.added(type);
		}
		return true;
	}


	public boolean add(String wagon, String Train) {
		// add wg1 to tr1;
		
		
		tc.AddTrainPart(Train, wagon);
		
	
		return true;
	}

//	public static boolean save() {
//		
//		return true;
//	}

	public static void remove() {

	}

	public static void select() {

	}

}
