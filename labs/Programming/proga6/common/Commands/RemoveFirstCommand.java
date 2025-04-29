package common.Commands;

import common.Engine.ExecutionResponce;
import common.Entity.CityImport;
import java.util.ArrayList;
/**
 * Класс команды для удаления первого элемента из коллекции
 * @author Alexander Sokolov
 * @version 1.0
 */
public class RemoveFirstCommand implements CollectionableCommand{
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        try {
            receiver.remove();
        } catch (Exception e) {
            return new ExecutionResponce("Collection items are out of stock: " + e.toString());
        }
        return new ExecutionResponce("Первый элемент удален успешно");
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "remove_first : удалить первый элемент из коллекции";
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
    public String getCmdName(){return "remove_first";}
}
