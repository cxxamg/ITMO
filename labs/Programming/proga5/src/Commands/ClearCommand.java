package Commands;

import java.util.ArrayList;
/**
 * Класс команды для очищения коллекции
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ClearCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public void execute(String FilePath){
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("clear : очистить коллекцию");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(){
        receiver.clear();
    }
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
