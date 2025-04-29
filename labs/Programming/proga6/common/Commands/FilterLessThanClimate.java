package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Entity.City;
import common.Entity.CityImport;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
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
    public ExecutionResponce execute(String idStr){
        try {
            int id = Integer.parseInt(idStr);
            if (id > 4) {
                throw new NoSuchElementException();
            }

            String result = Receiver.stack.stream()
                    .filter(city -> id > city.getClimate().getValue())
                    .map(City::toString)
                    .collect(Collectors.joining("\n"));

            if (result.isEmpty()) {
                return new ExecutionResponce("Городов с условием id > climateValue не найдено");
            }

            return new ExecutionResponce("Найденные города:\n" + result);

        } catch (NoSuchElementException e) {
            return new ExecutionResponce("Такого элемента нет в Climate");
        } catch (NumberFormatException e) {
            return new ExecutionResponce("Некорректный ID Climate");
        } catch (Exception e) {
            return new ExecutionResponce("Ошибка при парсинге id Climate: " + e);
        }
    }
    @Override
    public ExecutionResponce execute(){return null;
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "filter_less_than_climate climate : вывести элементы, значение поля climate которых меньше заданного";
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
    @Override
    public boolean parseValue(String idStr){
        try {
            int id = Integer.parseInt(idStr);
            if (id > 4){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "filter_less_than_climate";}
}