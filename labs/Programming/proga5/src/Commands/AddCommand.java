package Commands;

import Engine.*;
import Engine.ScriptManager.AskScript;
import Entity.City;
import java.util.ArrayList;
/**
 * Класс команды для добавления нового элемента в коллекцию
 * @author Alexander Sokolov
 * @version 1.0
 */
public class AddCommand implements CollectionableCommand, Validatable{
    /**Выполенение команды add для обычной консоли*/
    @Override
    public void execute(){
        City city = null;
        boolean isIdNotBusy = true;
        try{
        city = Ask.askCity();
        }   catch (Ask.AskBreak e) {
        
        }
        if (city != null){
            for (int i = 0; i < receiver.size(); i++) {
                if (city.getId() == Receiver.stack.get(i).getId()){
                    isIdNotBusy = false;
                }
            }
            if (isIdNotBusy){
                receiver.add(city);
            }else{
                city.setId(city.getId()+1);
                Ask.setCityCount(Ask.getCityCount()+1);
                receiver.add(city);
            }
            System.out.println("City id=" + city.getId() + " is created");
            }
    }

    /**Выполенение команды add для скрипта 
     * @param validatableValues Значения для валидации
    */
    @Override
    public void execute(ArrayList<String> validatableValues){
        boolean isIdNotBusy = true;
        City city = null;
        try {
            city = AskScript.askCity(validatableValues);
        } catch (Ask.AskBreak e) {
            System.out.println("City isn't created");
        }
        if (city != null){
            for (int i = 0; i < receiver.size(); i++) {
                if (city.getId() == Receiver.stack.get(i).getId()){
                    isIdNotBusy = false;
                }
            }
            if (isIdNotBusy){
                receiver.add(city);
            }else{
                city.setId(city.getId()+1);
                Ask.setCityCount(Ask.getCityCount()+1);
                receiver.add(city);
            }
            System.out.println("City id=" + city.getId() + " is created");
            }
    }

    /** Описание команды */
    @Override
    public void describe(){
        System.out.println("add {element} : добавить новый элемент в коллекцию");
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }

    @Override
    public void execute(String s){}

    @Override
    public void execute(ArrayList<String> arg,String id){}
}
