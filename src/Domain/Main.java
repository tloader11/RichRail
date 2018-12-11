package Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DataSource.DataHandler;
import DataSource.FileHandler;
import TrainComponenten.Locomotive;
import TrainComponenten.Wagon;

public class Main {

	public static List<Train> trainsList = Collections.synchronizedList(new ArrayList<Train>());
	public static List<Component> componentsList = Collections.synchronizedList(new ArrayList<Component>());

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{

		System.out.println("Welcome to the RichRail interface! Please enter your command.");
		System.out.println("use getcommands to see al available commands...!");

		ConsoleReader reader = new ConsoleReader();
		reader.start();

		System.out.println("Reader is running...!");

		/*
		Train t1 = new Train("first train");
		t1.addComponent(new Wagon());
		t1.addComponent(new Locomotive());
		t1.addComponent(new Wagon());
		t1.addComponent(new Wagon());
		
		
		
		DataHandler file = new FileHandler();
		file.addTrain(t1);
		*/
	}

}