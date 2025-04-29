package common.Commands;

import common.Engine.*;
import common.Entity.CityImport;
import java.util.ArrayList;
/**
 * Класс команды для истории команд
 * @author Alexander Sokolov
 * @version 1.0
 */
public class HistoryCommand implements Command{
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        return new ExecutionResponce(CommandHistory.printLastCommands());
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "history : вывести последние 9 команд (без их аргументов)";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public ExecutionResponce execute(String s){return null;}
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){return true;}
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "history";}
}
