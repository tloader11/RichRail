package Domain;

import TrainComponenten.Locomotive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum commands {
    NEW             (0),  //calls constructor with value 0
    ADD             (1),  //calls constructor with value 1
    GETNUMSEATS     (2),   //calls constructor with value 2
    DELETE          (3),   //calls constructor with value 3
    REMOVE          (4),   //calls constructor with value 4
    SAVE            (5),   //calls constructor with value 5
    ; // semicolon needed when fields / methods follow


    private final int _commandCode;

    private commands(int commandCode) {
        this._commandCode = commandCode;
    }

    public static Pattern getPattern(commands c)
    {
        switch (c)
        {
            case NEW:
                return Pattern.compile("new (train) (\\S*);|new (wagon) (\\S*)( (numseats) (\\d*))?;");
            case ADD:
                return Pattern.compile("add (\\S*) to (\\S*);");
            case GETNUMSEATS:
                return Pattern.compile("new (train) (\\S*);|new (wagon) (\\S*)( numseats (\\d*);)?");
            case DELETE:
                return Pattern.compile("new (train) (\\S*);|new (wagon) (\\S*)( numseats (\\d*);)?");
            case REMOVE:
                return Pattern.compile("new (train) (\\S*);|new (wagon) (\\S*)( numseats (\\d*);)?");
            case SAVE:
                return Pattern.compile("save;");
        }
        return null;
    }

    public static boolean checkSyntax(commands c, String text)
    {
        Pattern pattern = getPattern(c);
        switch(c)
        {
            case NEW:
                if( text.matches( pattern.pattern() )) return true;
                return false;
            case ADD:
                if( text.matches( pattern.pattern() )) return true;
                return false;
            case GETNUMSEATS:
                if( text.matches( pattern.pattern() )) return true;
                return false;
            case DELETE:
                if( text.matches( pattern.pattern() )) return true;
                return false;
            case REMOVE:
                if( text.matches( pattern.pattern() )) return true;
                return false;
            case SAVE:
                if( text.matches( pattern.pattern() )) return true;
                return false;
        }

        return false;
    }

}