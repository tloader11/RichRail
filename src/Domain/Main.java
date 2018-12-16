package Domain;

import java.io.IOException;

import javax.swing.SwingUtilities;

import TaskLayer.TrainController;
import TaskLayer.TrainPartController;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * TrainController tc = new TrainController(); TrainPartController tpc = new
		 * TrainPartController(); //tc.createTrain("jaco"); tc.AddTrainPart("jaco",
		 * "Wagon");
		 */
	    TrainController tc = new TrainController();
	    TrainPartController tpc = new TrainPartController();
		System.out.println("Welcome to the RichRail interface! Please enter your command.");
		System.out.println("use getcommands to see al available commands...!");

		ConsoleReader reader = new ConsoleReader();
		reader.start();

		System.out.println("Reader is running...!");

		if(args.length == 0)
		{
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					UserInterface inst = new UserInterface();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
					inst.loadTrains();
				}
			});
		}
		else if(args[0].equalsIgnoreCase("-c"))
		{
			//console only!
			System.out.println("Started in console only mode...!");
		}

	}

}