package Commands;

import java.util.ArrayList;
/**
 * Класс команды для сохранения коллекции в Xml файл
 * @author Alexander Sokolov
 * @version 1.0
 */
public class SaveCommand implements CollectionableCommand{
    /**Реализация команды */
    @Override
    public void execute(){
        receiver.save();
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("save : сохранить коллекцию в файл");
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
