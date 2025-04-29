package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Entity.City;
import common.Entity.CityImport;
import java.util.ArrayList;
import java.util.Optional;
/**
 * Класс команды для вывода любого элемента из коллекции, значения поля metersAboveSeaLevel будет являться максимальным
 * @author Alexander Sokolov
 * @version 1.0
 */
public class MaxByMetersAboveSeaLevel implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        Optional<City> maxCity = Receiver.stack.stream()
        .max((c1, c2) -> Integer.compare(
            c1.getMetersAboveSeaLevel(),
            c2.getMetersAboveSeaLevel()
        ));
    
    return maxCity.map(c -> new ExecutionResponce(c.toString()))
                .orElse(new ExecutionResponce("Коллекция пуста"));
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "max_by_meters_above_sea_level : вывести любой объект из коллекции, значение поля metersAboveSeaLevel которого является максимальным";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public ExecutionResponce execute(String s){return null;}
    @Override
    public void execute(ArrayList<String> args){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){return true;}
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "max_by_meters_above_sea_level";}
}
