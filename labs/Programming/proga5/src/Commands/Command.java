package Commands;

import java.util.ArrayList;

public interface Command {
    void execute();        
    void execute(String arg);
    void execute(ArrayList<String> args);
    public void execute(ArrayList<String> args, String id);
    void describe();
    int getValuesCount(); 
}
