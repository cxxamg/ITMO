package Commands;

import java.util.ArrayList;

public class UpdateIdCommand implements CollectionableCommand, Validatable{
    @Override
    public void execute(){
    }
    @Override
    public void describe(){
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
    }
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public void execute(String id){
        receiver.update(id);
    }
    @Override
    public void execute(ArrayList<String> validatableValues, String id){
        receiver.update(validatableValues, id);
    }
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
}
