package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.ServerInvoker;
import common.Entity.CityImport;
import java.util.ArrayList;
//import common.Engine.Invoker;

/**
 * Класс команды для помощи по командам
 * @author Alexander Sokolov
 * @version 1.0
 */
public class HelpCommand implements Command{
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        StringBuilder sb = new StringBuilder();
        ServerInvoker inv = new ServerInvoker();
        for (Command c : inv.commandz.values()) {
            sb.append(c.describe()).append("\n");
        }
        return new ExecutionResponce(sb.toString());
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "help : вывести справку по доступным командам";
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
    public String getCmdName(){return "help";}
}


