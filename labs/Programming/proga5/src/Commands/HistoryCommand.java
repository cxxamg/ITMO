package Commands;

import java.util.ArrayList;

import Engine.*;

public class HistoryCommand implements Command{
    @Override
    public void execute(){
        Receiver.history();
    }
    @Override
    public void describe(){
        System.out.println("history : вывести последние 9 команд (без их аргументов)");
    }
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String arg){}
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
