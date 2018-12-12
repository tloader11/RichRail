package Domain;

import java.util.HashMap;
import java.util.regex.Matcher;

import DataSource.DataHandler;
import DataSource.FileHandler;
import TrainComponenten.Wagon;

public class Controller {

	
	public static boolean create(String name, String type, int numseats) {
	        if(type != null && type.equalsIgnoreCase("train"))
	        {
	       //     returnMap.put("type", Train.class);
	            Train train = new Train(name);
	            
              Main.trainsList.add(train);
              ConsoleReader.added(type);
//              
	        //    returnMap.put("object", train);
	        }
	        else if(type != null && type.equalsIgnoreCase("wagon"))
	        {
	        //    returnMap.put("type", Wagon.class);
	            Wagon wagon = new Wagon(name);
	            if(numseats != 0)
	            {
	                wagon.setSeats( numseats);
	            }
	            
	            Main.componentsList.add(wagon);
	            ConsoleReader.added(type);
	         //   returnMap.put("object", wagon);
	        }
	     return true;
	}
	
	public static boolean add(String component, String Train) {
		 //add wg1 to tr1;
        for (int i = 0; i < Main.trainsList.size(); i++)
        {
            Train train  = Main.trainsList.get(i);
            System.out.println("trein " + train.name);
            System.out.println("opgevraagd " + Train);
            System.out.println("opgevraagd " + component);
            if(train.name.equalsIgnoreCase(Train))
            {
                for (Component c : Main.componentsList)
                {
                    System.out.println("Itteration 2.");
                    if(c.name.equalsIgnoreCase(component))
                    {
                        train.addComponent(c);
                        if(c instanceof Wagon)
                        {
                   //         returnMap.put("message", "Wagon "+component+" added to train " + Train);
                        }
                        return true;
                    }
                }
                break;
            }
        }
        return true;
	}
	
	public static boolean save() {
		  DataHandler file = new FileHandler();
          for (Train train : Main.trainsList )
          {
              file.addTrain(train);
          }
          return true;
	}
	
	public static void remove() {
		
	}
	
	public static void select() {
		
	}
	
	
	

}
