package Domain;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleReader extends Thread
{
    public static void added(String name) {
    	System.out.println("Added "  + name  + " with success !");
    }
    
    public static void numbseats(String name, String type, int seats) {
    	System.out.println("number of seats in "+ type  + " " + name  + ": " + seats );
    }
    
    public void run()
    {
        CommandProcessor processor = new CommandProcessor();
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            System.out.println("You issued the following command: " + command);

            boolean result = false;
			try {
				result = processor.executeCommand(command);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            if(result == true)
            {
                System.out.println("Command was executed succesfully!");
            } else {
            	System.out.println("Something went wrong!");
            }
        }
    }
}