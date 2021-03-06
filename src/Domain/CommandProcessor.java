package Domain;

import DataSource.DataHandler;
import DataSource.FileHandler;
import Domain.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;

public class CommandProcessor
{
    private Controller cc = new Controller();
    private String _lastCommand;

    public CommandProcessor()
    {
        //Constructor. No need to initialize anything at this point. Just used to keep this object orientated.
        _lastCommand = "";
    }

    private boolean check_command(commands value)
    {
        try
        {       //just execute, if. Don't check for anything here.
            return commands.checkSyntax(value, this._lastCommand);
        }
        catch (IllegalArgumentException ex)
        {
            return false;   //command start not valid!!
        }
    }
    
    private commands processCommand(String command) {
    	String[] output = command.split(" ");
        output[0] = output[0].toUpperCase();
        output[0] = output[0].replace(";","");
        
    	return commands.valueOf(output[0]);
    }

    public boolean executeCommand(String command) throws FileNotFoundException, IOException {
        this._lastCommand = command;
        boolean success = false;
        List<String> allMatches = new ArrayList<String>();
        commands c = processCommand(this._lastCommand);
        if (check_command(c))
        {         
            Matcher m = c.getPattern(c).matcher(_lastCommand);
            m.find();
            if(c == commands.NEW)
            {
	           for (int i = 0; i < m.groupCount(); i++) {
	               if(m.group(i)!= null) {
	            	   allMatches.add(m.group(i));
	               }                                                                      
	            }
	            int numseats = 0;
            	 if(5 != allMatches.size()){
                 	allMatches.add("0");
                 	numseats = 0;
                 } else {
                	 String s = allMatches.get(3).split("numseats ")[1];
                	 numseats =  Integer.parseInt(s );
                 }
            	 
            	 success = cc.create(allMatches.get(2), allMatches.get(1), numseats);
            }

            else if(c == commands.ADD)
            {
            	allMatches.add(m.group(2));
            	success = cc.add(m.group(1), m.group(2));
            } 
            else if(c == commands.DELETE)
            {          
            	for (int i = 0; i <= m.groupCount(); i++) {
            		if(m.group(i)!= null) {
            			allMatches.add(m.group(i).split(";")[0]);
    	            }                                                                      
    	        }
            	success = cc.delete(allMatches.get(2), allMatches.get(1));
            }    
            else if(c == commands.GETNUMSEATS)
            {          
            	for (int i = 0; i <= m.groupCount(); i++) {
            		if(m.group(i)!= null) {
            			allMatches.add(m.group(i).split(";")[0]);
    	            }                                                                      
    	        }
            	int seats = 0;
            	if(cc.getnumseats(allMatches.get(2), allMatches.get(1)) != 0) {
            		success = true;
            	}     	
            } 
            else if(c == commands.REMOVE)
            {
             	allMatches.add(m.group(2));
            	success = cc.remove(m.group(1),m.group(2));
            } 
    
        }
        return success;
    }

}
