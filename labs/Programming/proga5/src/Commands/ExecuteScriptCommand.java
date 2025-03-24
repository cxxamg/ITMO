package Commands;
import Engine.*;
import java.util.ArrayList;

public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(String FilePath){
        Receiver.execute_script(FilePath);
    }
    @Override
    public void describe(){
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }
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
