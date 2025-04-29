package common.Commands;
import common.Engine.ExecutionResponce;
import common.Entity.CityImport;
import java.util.ArrayList;
/**
 * Класс команды для выхода из программы
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ExitCommand implements Command{
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(){
        return null;
        }
    
    @Override
    /** Описание команды */
    public String describe(){
        return "exit : завершить программу (без сохранения в файл)";
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
    public String getCmdName(){return "exit";}
}
