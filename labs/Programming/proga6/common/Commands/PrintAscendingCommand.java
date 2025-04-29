package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Entity.City;
import common.Entity.CityImport;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
/**
 * Класс команды для вывода элементов коллекции в порядке возрастания
 * @author Alexander Sokolov
 * @version 1.0
 */
public class PrintAscendingCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        String result = Receiver.stack.stream()
            .sorted(Comparator.comparingLong(City::getId))
            .map(City::toString)
            .collect(Collectors.joining("\n"));
    
        return new ExecutionResponce(result.isEmpty() ? "Коллекция пуста" : result);
        }
    
    /** Описание команды */
    @Override
    public String describe(){
        return "print_ascending : вывести элементы коллекции в порядке возрастания";
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
    public String getCmdName(){return "print_ascending";}
}