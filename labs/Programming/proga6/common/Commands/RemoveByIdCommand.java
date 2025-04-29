package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Entity.CityImport;
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
    public ExecutionResponce execute(String idStr){
        try {
            int id = Integer.parseInt(idStr);

            boolean removed = Receiver.stack.stream()
                    .filter(city -> city.getId() == id)  // Фильтруем по id
                    .findFirst()                        // Берём первый подходящий
                    .map(city -> Receiver.stack.remove(city)) // Удаляем из коллекции
                    .orElse(false);                      // Если не найден → false

            if (!removed) {
                throw new NoSuchElementException();
            }

            return new ExecutionResponce("Город удалён успешно");

        } catch (NumberFormatException e) {
            return new ExecutionResponce("Ошибка при парсинге id. Город не удалён");
        } catch (NoSuchElementException e) {
            return new ExecutionResponce("Такого элемента нет в стэке");
        } catch (Exception e) {
            return new ExecutionResponce("Город не удалён: " + e.toString());
        }

    }
    /** Описание команды */
    @Override
    public String describe(){
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public ExecutionResponce execute(){ return null;
    }
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){
        try {
            Integer.parseInt(idStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "remove_by_id";}
}
