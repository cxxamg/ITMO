package Commands;
import Engine.ScriptManager.ScriptInvoker;
import Engine.ScriptManager.ScriptReader;
import java.util.ArrayList;
/**
 * Класс команды для выполнения скрипта
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ExecuteScriptCommand implements Command {
    /**Реализация команды */
    @Override
    public void execute(String FilePath){
        ScriptReader.script_read(FilePath);
        //System.out.println(ScriptReader.script_commands);
        ScriptInvoker sI = new ScriptInvoker();
        sI.script_invoker(ScriptReader.script_commands);
        ScriptReader.clearScriptCommands();
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public void execute(){}
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
