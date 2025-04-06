package Commands;

import java.util.ArrayList;
/**
 * Интерфейс для всех команд
 * @author Alexander Sokolov
 * @version 1.0
 */
public interface Command {
    void execute();        
    void execute(String arg);
    void execute(ArrayList<String> args);
    public void execute(ArrayList<String> args, String id);
    void describe();
    int getValuesCount(); 
}
