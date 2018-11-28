package DataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import Domain.Train;

public class FileHandler implements DataHandler {
	private String filePath = "mySave.txt";
	private File f = new File(filePath);
	private PrintWriter writer;
	
	
	public void write(String yourText) throws FileNotFoundException {
		
		if ( f.exists() && !f.isDirectory() ) {
			writer = new PrintWriter(new FileOutputStream(new File(filePath), true));
			
		}
		else {
			writer = new PrintWriter(filePath);
		}
		
		writer.append(yourText);
		writer.close();
		
	}

public String trainTotxt(Train t) {
	String spaceingChar = ";";
	//test format to save train to.txt
	//the format is componentType,id
	//spaceingChar ; is added in the end of the whole train

	
		String s = "";
		List componenten = t.getComponenten();
		for (Object object : componenten) {
			s += object + "," ;
			
		}
	    s = s.substring(0, s.length() - 1);
	    s += spaceingChar ;
		return s;
}


	@Override
	public void addTrain(Train t) {
		try {
			write(trainTotxt(t));
			System.out.println("train is added to the file mysave.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
		
		
	}


	@Override
	public void editTrain(Train oldTrain, Train newTrain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteTrain(Train t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void viewTrain(String trainName) {
		// TODO Auto-generated method stub
		
	}
	
	

}
