package Domain;

/* this class is for test use
 * plz note that is is only connected to the controller classes 
 */

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		/*
		 * 
		 * 
		 * TrainController tc = new TrainController(); TrainPartController tpc = new
		 * TrainPartController();
		 * 
		 * //tc.createTrain("jaco");
		 * 
		 * 
		 * 
		 * 
		 * tc.AddTrainPart("jaco", "Wagon");
		 * 
		 */

		System.out.println("Welcome to the RichRail interface! Please enter your command.");
		System.out.println("use getcommands to see al available commands...!");

		ConsoleReader reader = new ConsoleReader();
		reader.start();

		System.out.println("Reader is running...!");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UserInterface inst = new UserInterface();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.loadTrains();
			}
		});

		// tc.createTrain("red");

		// tc.AddTrainPart("red","black");
		/*
		 * tc.AddTrainPart("ns Train","red"); tc.AddTrainPart("ns Train","green");
		 * tc.delTrainPart("ns Train", 2);
		 * 
		 * 
		 * // make new Train // Train t = tc.createTrain("soseh_train"); // Train t2 =
		 * tc.createTrain("red_train");
		 * 
		 * // add parts // tc.AddTrainPart("soseh_train","passenger1"); //
		 * tc.AddTrainPart("soseh_train","zain");
		 * 
		 * // tc.AddTrainPart("soseh_train","omar");
		 * 
		 * // tc.AddTrainPart("ns_train","wagon"); //
		 * tc.AddTrainPart("ns_train","newPart");
		 * 
		 * // delete parts // tc.delTrainPart("soseh_train", 2);
		 * 
		 * // delete train // tc.delTrain("ns_train");
		 * 
		 * // find train // System.out.println(tc.selectTrain("ns_train"));
		 * 
		 * // Train Part // tpc.CreateTrainPartType("first type", 88); //
		 * System.out.println(tpc.selectTrainPartTypes());
		 * //tpc.delPartType("first type"); // select all trains //
		 * System.out.println(tc.selectAllTrainCodes()); // to be added /* select all
		 * trains codes in an array select all types names in an array
		 * 
		 */
	}

}