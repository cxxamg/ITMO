package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Entity.CityImport;
import java.util.ArrayList;
/**
 * Класс команды для вывода коллекции в стандартный поток вывода
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ShowCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        return new ExecutionResponce(Receiver.stack.toString());
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public ExecutionResponce execute(String s){return null;}
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){return true;}
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "show";}
}
