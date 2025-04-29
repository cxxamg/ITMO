package common.Commands;

import common.Engine.Ask;
import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Engine.ScriptManage.AskScript;
import common.Entity.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Класс команды для обновления значения коллекции, id которого равен заданному
 * @author Alexander Sokolov
 * @version 1.0
 */
public class UpdateIdCommand implements CollectionableCommand, Validatable{
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){
        long id;
            boolean found = false;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < receiver.size(); i++) {
                    if (id == Receiver.stack.get(i).getId()){
                        City city = null;
                        try{
                        city = Ask.convertCityImportIntoCity(c);
                        }   catch (Ask.AskBreak e) {
                        
                        }
                        //var city = new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly"));
                        if (city != null){
                            city.setId(id);
                            Receiver.stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e){
                return new ExecutionResponce("Такого элемента нет в стэке");
            } catch (NumberFormatException e){
                return new ExecutionResponce("Ошибка при парсинге id. Город не обновлен");
            } catch (Exception e) {
                return new ExecutionResponce("Город не обновлен: " + e.toString());
            }
            return new ExecutionResponce("Город обновлен успешно");
    }
    /**Выполенение команды update для обычной консоли*/
    @Override
    public ExecutionResponce execute(String idStr){
        long id;
            boolean found = false;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < receiver.size(); i++) {
                    if (id == Receiver.stack.get(i).getId()){
                        City city = null;
                        try{
                        city = Ask.askCity();
                        }   catch (Ask.AskBreak e) {
                        
                        }
                        //var city = new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly"));
                        if (city != null){
                            city.setId(id);
                            Receiver.stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e){
                return new ExecutionResponce("Такого элемента нет в стэке");
            } catch (NumberFormatException e){
                return new ExecutionResponce("Ошибка при парсинге id. Город не обновлен");
            } catch (Exception e) {
                return new ExecutionResponce("Город не обновлен: " + e.toString());
            }
            return new ExecutionResponce("Город обновлен успешно");
    }
    /**Выполенение команды update для скрипта 
     * @param validatableValues Значения для валидации
     * @param idStr второй аргумент команды, значения id
    */
    @Override
    public void execute(ArrayList<String> validatableValues, String idStr){
        long id;
            boolean found = false;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < receiver.size(); i++) {
                    if (id == Receiver.stack.get(i).getId()){
                        City city = null;
                        try {
                            city = AskScript.askCity(validatableValues);
                            Ask.setCityCount(Ask.getCityCount()-1);
                        } catch (Ask.AskBreak e) {
                            System.out.println("City isn't updated");
                            found = true;
                        }
                        if (city != null){
                            city.setId(id);
                            Receiver.stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e){
                System.out.println("No such element in stack" + e.toString());
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't updated");
            } catch (Exception e) {
                System.out.println("City isn't updated: " + e.toString());
            }
    }
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
    @Override
    public ExecutionResponce execute(){return null;
    }
    /** Описание команды */
    @Override
    public String describe(){
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public boolean parseValue(String idStr){
        try {
            Long.parseLong(idStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override 
    public String getCmdName(){return "update_id";}
}
