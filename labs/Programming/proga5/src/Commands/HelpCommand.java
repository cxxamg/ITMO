package Commands;

import Engine.Invoker;
import java.util.ArrayList;

/**
 * Класс команды для помощи по командам
 * @author Alexander Sokolov
 * @version 1.0
 */
public class HelpCommand implements Command{
    /**Реализация команды */
    @Override
    public void execute(){
        Invoker inv = new Invoker();
        for (Command c : inv.commandz.values()) {
            c.describe();
  }
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("help : вывести справку по доступным командам");
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


