package Commands;

import Engine.Ask;
import Engine.Receiver;
import Engine.ScriptManager.AskScript;
import Entity.City;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Класс команды для добавления нового элемента в заданную позицию
 * @author Alexander Sokolov
 * @version 1.0
 */
public class InsertAtCommand implements CollectionableCommand, Validatable{
    /**Выполенение команды insert_at для обычной консоли*/
    @Override
    public void execute(String idStr){
        long id;
        boolean found = false;
        City city = null;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < receiver.size(); i++) {
                    if (id == Receiver.stack.get(i).getId()){
                        try{
                        city = Ask.askCity();
                        }   catch (Ask.AskBreak e) {
                            System.out.println("City isn't inserted at collection");
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
                    try {
                        city = Ask.askCity();
                        Ask.setCityCount(Ask.getCityCount()-1);
                    } catch (Ask.AskBreak e) {
                        System.out.println("City isn't inserted at collection");
                    }
                    if (city != null){
                        city.setId(id);
                        receiver.add(city);
                    }
                }
            } catch (NoSuchElementException e){
                System.out.println("No such element in stack");
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't inserted");
            } catch (Exception e) {
                System.out.println("City isn't inserted: " + e.toString());
            }
    }
    /**Выполенение команды insert_at для скрипта 
     * @param validatableValues Значения для валидации
     * @param idStr второй аргумент команды, значения id
    */
    @Override
    public void execute(ArrayList<String> validatableValues, String idStr){
        long id;
        boolean found = false;
        City city = null;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < receiver.size(); i++) {
                    if (id == Receiver.stack.get(i).getId()){
                        try {
                            city = AskScript.askCity(validatableValues);
                            Ask.setCityCount(Ask.getCityCount()-1);
                        } catch (Ask.AskBreak e) {
                            System.out.println("City isn't inserted at collection");
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
                    try {
                        city = AskScript.askCity(validatableValues);
                        Ask.setCityCount(Ask.getCityCount()-1);
                    } catch (Ask.AskBreak e) {
                        System.out.println("City isn't inserted at collection");
                    }
                    if (city != null){
                        city.setId(id);
                        receiver.add(city);
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't inserted");
            } catch (Exception e) {
                System.out.println("City isn't inserted: " + e.toString());
            }
    }

    @Override
    public void execute(){
    }
    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("insert_at index {element} : добавить новый элемент в заданную позицию");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 2;
    }

    @Override
    public void execute(ArrayList<String> validatableValues){
    }
}
