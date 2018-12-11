package Domain;

import TrainComponenten.Wagon;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleReader extends Thread
{
    @Override
    public void run()
    {
        CommandProcessor processor = new CommandProcessor();
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            System.out.println("You issued the following command: " + command);

            HashMap<String, Object> result = processor.executeCommand(command);

            if((boolean)result.get("success"))
            {
                if(result.get("type") == Train.class)
                {
                    Main.trainsList.add((Train)result.get("object"));
                    System.out.println("Added train with success !");
                }
                else if(result.get("type") == Wagon.class)
                {
                    Main.componentsList.add((Wagon)result.get("object"));
                    System.out.println("Added wagon with success !");
                }
                System.out.println("Added item with success !");
            }
        }
    }
}