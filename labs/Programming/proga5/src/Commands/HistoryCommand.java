package Commands;

import Engine.*;
import java.util.ArrayList;
/**
 * Класс команды для истории команд
 * @author Alexander Sokolov
 * @version 1.0
 */
public class HistoryCommand implements Command{
    /**Реализация команды */
    @Override
    public void execute(){
        CommandHistory.printLastCommands();
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("history : вывести последние 9 команд (без их аргументов)");
    }
    /** Кол-во элементов команды */
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
