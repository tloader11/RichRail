package DataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Domain.ConsoleReader;
import Domain.Train;
import Domain.trainPart.TrainPart;
import Domain.trainPart.TrainPartFactory;

public class FileHandler implements DataHandler {
	File f = new File("txt/mySave.txt");
	File t = new File("txt/types.txt");
	private String filePath = "mySave.txt";
	private TextEditor ed = new TextEditor();

	@Override
	public void addTrain(Train t) {
		try {
			if(ed.selectAllcodes().size() < 3) {
				ed.write(ed.trainTotxt(t), f);
				System.out.println("train is added to the file mysave.txt");
				ConsoleReader.added(t.getCode());
			} else {
				System.out.println("Maximum treinen bereikt");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editTrain(String oldTraincode, Train newTrain) {
		try {
			// delete old one
			ed.delTrain(oldTraincode, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// add new one
		addTrain(newTrain);
		System.out.println("Train is successfully updated");

	}

	@Override
	public void deleteTrain(String trainCode) {
		try {
			ed.delTrain(trainCode, f);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Train selectTrain(String trainName) {
		TrainPartFactory tpf = new TrainPartFactory();
		Train t = null;

		try {
			List l = ed.findTrain(trainName);
			t = new Train(String.valueOf(l.get(0)));

			for (int i = 1; i < l.size(); i++) {
				TrainPart part = tpf.makeTrainPart(String.valueOf(l.get(i)));
				t.addParts(part);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> selectAllTrainCodes() {

		return ed.selectAllcodes();
	}

	@Override
	public void addRollerType(String type, int zitPlaatsen) {
		String s = type + ", " + zitPlaatsen + "\n";
		try {
			if(ed.selectAlltypes().size() < 6) {
				if(ed.selectAlltypes().contains(s)){
					System.out.println("as" + ed.selectAlltypes().contains(s));
				}
				ed.write(s, t);
				System.out.println("wagon is added to the file types.txt");
				ConsoleReader.added(type);
			} else {
				System.out.println("Maximum trainpart types bereikt");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List selectAllTypes() {
		return ed.selectAlltypes();
	}

	@Override
	public void delType(String type) {
		try {

			ed.delTrain(type, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
