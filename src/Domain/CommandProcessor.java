package Domain;

import DataSource.DataHandler;
import DataSource.FileHandler;
import TrainComponenten.Locomotive;
import TrainComponenten.Wagon;

import java.util.*;
import java.util.regex.Matcher;

public class CommandProcessor
{

    private String _lastCommand;

    public CommandProcessor()
    {
        //Constructor. No need to initialize anything at this point. Just used to keep this object orientated.
        _lastCommand = "";
    }

    private boolean check_command()
    {
        try
        {
            String[] output = this._lastCommand.split(" ");
            output[0] = output[0].toUpperCase();
            output[0] = output[0].replace(";","");
            commands value = commands.valueOf(output[0]);        //just execute, if. Don't check for anything here.
            return commands.checkSyntax(value, this._lastCommand);

        }
        catch (IllegalArgumentException ex)
        {
            return false;   //command start not valid!!
        }
    }

    public HashMap<String, Object> executeCommand(String command) {
        this._lastCommand = command;
        boolean success = false;
        HashMap<String, Object> returnMap = new HashMap<>();

        if (check_command())
        {

            String[] output = this._lastCommand.split(" ");
            output[0] = output[0].toUpperCase();
            output[0] = output[0].replace(";","");
            commands c = commands.valueOf(output[0]);
            if(c == commands.NEW)
            {
                Matcher m = c.getPattern(c).matcher(_lastCommand);
                m.find();

                if(m.group(1) != null && m.group(1).equalsIgnoreCase("train"))
                {
                    returnMap.put("type", Train.class);
                    Train train = new Train(m.group(2));
                    returnMap.put("object", train);
                }
                else if(m.group(3) != null && m.group(3).equalsIgnoreCase("wagon"))
                {
                    returnMap.put("type", Wagon.class);
                    Wagon wagon = new Wagon();
                    wagon.name = m.group(4);
                    if(m.group(6) != null && m.group(6).equalsIgnoreCase("numseats"))
                    {
                        wagon.setSeats( Integer.parseInt( m.group(7) ));
                    }
                    returnMap.put("object", wagon);
                }
                success = true;
            }
            else if(c == commands.SAVE)
            {
                DataHandler file = new FileHandler();
                for (Train train : Main.trainsList )
                {
                    file.addTrain(train);
                }
                success = true;
            }
            else if(c == commands.ADD)
            {
                //add wg1 to tr1;
                Matcher m = c.getPattern(c).matcher(_lastCommand);
                m.find();
                String trainName = m.group(2);
                String componentName = m.group(1);
                for (int i = 0; i < Main.trainsList.size(); i++)
                {
                    Train train  = Main.trainsList.get(i);
                    System.out.println(train.name);
                    System.out.println(trainName);

                    if(train.name.equalsIgnoreCase(trainName))
                    {
                        for (Component component : Main.componentsList)
                        {
                            System.out.println("Itteration 2.");
                            if(component.name.equalsIgnoreCase(componentName))
                            {
                                train.addComponent(component);
                                if(component instanceof Wagon)
                                {
                                    returnMap.put("message", "Wagon "+componentName+" added to train " + trainName);
                                }
                                success = true;
                            }
                        }
                        break;
                    }
                }

            }
        }
        returnMap.put("success", success);
        return returnMap;
    }

}
