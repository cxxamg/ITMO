package common.Commands;

import common.Engine.ExecutionResponce;
import common.Entity.*;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Интерфейс для всех команд
 * @author Alexander Sokolov
 * @version 1.0
 */
public interface Command extends Serializable{
    ExecutionResponce execute();        
    ExecutionResponce execute(String arg);
    void execute(ArrayList<String> args); //e_s
    ExecutionResponce execute(CityImport c, String idStr);
    void execute(ArrayList<String> args, String id); //e_s
    String describe();
    int getValuesCount(); 
    boolean parseValue(String idStr);
    String getCmdName();
}
