package Commands;

import Engine.Receiver;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Класс команды для вывода элементов, значение поля climate которых меньше заданного
 * @author Alexander Sokolov
 * @version 1.0
 */
public class FilterLessThanClimate implements CollectionableCommand {
    /**Реализация команды
     * @param idStr id Климата
     */
    @Override
    public void execute(String idStr){
        int id;
        try {
            id = Integer.parseInt(idStr);
            if (id > 4){
                throw new NoSuchElementException();
            }
            for (int i = 0; i < receiver.size(); i++) {
                if (id > Receiver.stack.get(i).getClimate().getValue()){
                    System.out.println(Receiver.stack.get(i));
                }
            }

        } catch (NoSuchElementException e){
            System.out.println("No such element in Climate");
        }  catch (NumberFormatException e){
            System.out.println("Incorrect id of Climate");
        } catch (Exception e) {
            System.out.println("Error while parsing id of Climate: " + e.toString());
        }
    }
    @Override
    public void execute(){
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("filter_less_than_climate climate : вывести элементы, значение поля climate которых меньше заданного");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public void execute(ArrayList<String> args){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
}