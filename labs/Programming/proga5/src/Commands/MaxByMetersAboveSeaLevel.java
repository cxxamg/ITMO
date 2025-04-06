package Commands;

import Engine.Receiver;
import Entity.City;
import java.util.ArrayList;
/**
 * Класс команды для вывода любого элемента из коллекции, значения поля metersAboveSeaLevel будет являться максимальным
 * @author Alexander Sokolov
 * @version 1.0
 */
public class MaxByMetersAboveSeaLevel implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public void execute(){
        int maxEl = 0;
        City cityEl = null;
        for (int i = 0; i < receiver.size(); i++) {
            int curMeters = Receiver.stack.get(i).getMetersAboveSeaLevel();
            if (maxEl < curMeters){
                maxEl = curMeters;
                cityEl = Receiver.stack.get(i);
            }
        }
        System.out.println(cityEl);
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("max_by_meters_above_sea_level : вывести любой объект из коллекции, значение поля metersAboveSeaLevel которого является максимальным");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String s){}
    @Override
    public void execute(ArrayList<String> args){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
