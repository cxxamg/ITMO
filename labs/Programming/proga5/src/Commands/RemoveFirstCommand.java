package Commands;

import java.util.ArrayList;
/**
 * Класс команды для удаления первого элемента из коллекции
 * @author Alexander Sokolov
 * @version 1.0
 */
public class RemoveFirstCommand implements CollectionableCommand{
    /**Реализация команды */
    @Override
    public void execute(){
        try {
            receiver.remove();
        } catch (Exception e) {
            System.out.println("Collection items are out of stock: " + e.toString());
        }
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("remove_first : удалить первый элемент из коллекции");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String s){}
    @Override
    public void execute(ArrayList<String> args){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
