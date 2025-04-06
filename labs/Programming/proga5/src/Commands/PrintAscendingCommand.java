package Commands;

import Engine.Receiver;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/**
 * Класс команды для вывода элементов коллекции в порядке возрастания
 * @author Alexander Sokolov
 * @version 1.0
 */
public class PrintAscendingCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public void execute(){
        Map<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < receiver.size(); i++) {
            map.put(Receiver.stack.get(i).getId(), i);
            //System.out.println(Receiver.stack.get(i));
        }
        for (long i = 0; i < receiver.size(); i++) {
            int idValue = map.get(i);
            System.out.println(Receiver.stack.get(idValue));
            //System.out.println(Receiver.stack.get(i));
        }
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("print_ascending : вывести элементы коллекции в порядке возрастания");
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