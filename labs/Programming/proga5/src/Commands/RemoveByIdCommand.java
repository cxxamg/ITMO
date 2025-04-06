package Commands;

import Engine.Receiver;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Класс команды для удаления из коллекции по id
 * @author Alexander Sokolov
 * @version 1.0
 */
public class RemoveByIdCommand implements CollectionableCommand {
    /**Реализация команды 
     * @param idStr id элемента из коллекции
    */
    @Override
    public void execute(String idStr){
        int id;
        boolean found = false;
        try {
            id = Integer.parseInt(idStr);
            for (int i = 0; i < receiver.size(); i++) {
                if (id == Receiver.stack.get(i).getId()){
                    receiver.remove(Receiver.stack.get(i));
                    found = true;
                    break;
                }
            }
            if (!found){
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e){
            System.out.println("No such element in stack");
        } catch (NumberFormatException e){
            System.out.println("Error while parsing id. City isn't deleted");
        } catch (Exception e) {
            System.out.println("City isn't deleted: " + e.toString());
        }
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public void execute(){
    }
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
