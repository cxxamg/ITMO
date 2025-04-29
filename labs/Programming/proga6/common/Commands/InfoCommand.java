package common.Commands;

import common.Engine.ExecutionResponce;
import common.Engine.Receiver;
import common.Entity.CityImport;
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
    public ExecutionResponce execute(){
        String type = Receiver.stack.getClass().getName();
        int size = receiver.size();
        LocalDate date = LocalDate.now();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Тип стека: ").append(type).append("\n")
        .append("Количество элементов в стеке: ").append(size).append("\n")
        .append("Дата инициализации: ").append(date);
        
        if (!Receiver.stack.isEmpty()) {
            Class<?> elementType = Receiver.stack.peek().getClass();
            sb.append("\nТип элементов в стеке: ").append(elementType.getName());
        }
        return new ExecutionResponce(sb.toString());
    }

    /** Описание команды */
    @Override
    public String describe(){
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
    /** Кол-во элементов команды */
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public ExecutionResponce execute(String s){return null;}
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
    @Override
    public boolean parseValue(String idStr){return true;}
    @Override 
    public ExecutionResponce execute(CityImport c, String idStr){return null;}
    @Override 
    public String getCmdName(){return "info";}
}
