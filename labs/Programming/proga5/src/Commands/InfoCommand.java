package Commands;

import Engine.Receiver;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Класс команды для получения информации по коллекции
 * @author Alexander Sokolov
 * @version 1.0
 */
public class InfoCommand implements CollectionableCommand {
    /**Реализация команды */
    @Override
    public void execute(){
        String type = Receiver.stack.getClass().getName();

        int size = receiver.size();
        LocalDate date = LocalDate.now();

        System.out.println("Тип стека: " + type);
        System.out.println("Количество элементов в стеке: " + size);
        System.out.println("Дата инициализации: " + date);
        if (!Receiver.stack.isEmpty()) {
            Class<?> elementType = Receiver.stack.peek().getClass();  
            System.out.println("Тип элементов в стеке: " + elementType.getName());
        }
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
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
