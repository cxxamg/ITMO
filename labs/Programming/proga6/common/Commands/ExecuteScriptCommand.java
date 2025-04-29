package common.Commands;
import common.Engine.ExecutionResponce;
import common.Entity.CityImport;
import java.util.ArrayList;
/**
 * Класс команды для выполнения скрипта
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ExecuteScriptCommand implements Command {
    /**Реализация команды */
    @Override
    public ExecutionResponce execute(String FilePath){
        return null;
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public ExecutionResponce execute(){return null;}
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String str){return true;}
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "execute_script";}
}
