package common.Commands;

import common.Engine.ExecutionResponce;
import common.Entity.CityImport;
import java.util.ArrayList;
/**
 * Класс команды для очищения коллекции
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ClearCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(String s){return null;}
    /** Описание команды */
    @Override
    public String describe(){
       return "clear : очистить коллекцию";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public ExecutionResponce execute(){
        receiver.clear();
        return new ExecutionResponce("Очистка выполенена успешно");
    }
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){return true;}
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "clear";}
}
