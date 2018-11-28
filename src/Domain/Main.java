package Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import DataSource.DataHandler;
import DataSource.FileHandler;
import TrainComponenten.Locomotive;
import TrainComponenten.Wagon;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		Train t1 = new Train("first train");
		t1.addComponent(new Wagon());
		t1.addComponent(new Locomotive());
		t1.addComponent(new Wagon());
		t1.addComponent(new Wagon());
		
		
		
		DataHandler file = new FileHandler();
		file.addTrain(t1);
}
	
	
}