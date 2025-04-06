package Commands;

import Engine.Receiver;
import java.util.ArrayList;
/**
 * Класс команды для вывода коллекции в стандартный поток вывода
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ShowCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public void execute(){
        for (int i = 0; i < receiver.size(); i++) {
            System.out.println(Receiver.stack.get(i));
        }
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String s){}
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
    
}
