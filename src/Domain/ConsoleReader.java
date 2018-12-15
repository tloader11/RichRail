package Domain;


import java.util.HashMap;
import java.util.Scanner;

public class ConsoleReader extends Thread
{
    public static void added(String name) {
    	System.out.println("Added "  + name  + " with success !");
    }
    
    public void run()
    {
        CommandProcessor processor = new CommandProcessor();
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            System.out.println("You issued the following command: " + command);

            boolean result = processor.executeCommand(command);

            if(result == true)
            {
                System.out.println("Command was executed succesfully!");
            } else {
            	System.out.println("Something went wrong!");
            }
        }
    }
}