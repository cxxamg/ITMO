package common.Commands;

import common.Engine.*;
import common.Engine.ScriptManage.AskScript;
import common.Entity.*;
import java.util.ArrayList;
/**
 * Класс команды для добавления нового элемента в коллекцию
 * @author Alexander Sokolov
 * @version 1.0
 */
public class AddCommand implements CollectionableCommand, Validatable{

    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){
        boolean isIdNotBusy = true;
        City city = null;
        try {
            city = Ask.convertCityImportIntoCity(c);
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
        } catch (Ask.AskBreak e) {
            return new ExecutionResponce("Ошибка при добавлении");
        }
        return new ExecutionResponce("City id=" + city.getId() + " is created");
        //System.out.println("City id=" + city.getId() + " is created");
    }

    /**Выполенение команды add для обычной консоли*/
    @Override
    public ExecutionResponce execute(){
        // City city = null;
        // boolean isIdNotBusy = true;
        // try{
        // city = Ask.askCity();
        // }   catch (Ask.AskBreak e) {
        
        // }
        // if (city != null){
        //     for (int i = 0; i < receiver.size(); i++) {
        //         if (city.getId() == Receiver.stack.get(i).getId()){
        //             isIdNotBusy = false;
        //         }
        //     }
        //     if (isIdNotBusy){
        //         receiver.add(city);
        //     }else{
        //         city.setId(city.getId()+1);
        //         Ask.setCityCount(Ask.getCityCount()+1);
        //         receiver.add(city);
        //     }
        //     System.out.println("City id=" + city.getId() + " is created");
        //     }
        return null;
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
    public String describe(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }

    @Override
    public ExecutionResponce execute(String s){return null;}

    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){return true;}
    @Override 
    public String getCmdName(){return "add";}
}
