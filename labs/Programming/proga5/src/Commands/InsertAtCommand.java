package Commands;

import java.util.ArrayList;

public class InsertAtCommand implements CollectionableCommand, Validatable{
    @Override
    public void execute(){
    }
    @Override
    public void describe(){
        System.out.println("insert_at index {element} : добавить новый элемент в заданную позицию");
    }
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public void execute(String id){
        receiver.insert_at(id);
    }
    @Override
    public void execute(ArrayList<String> validatableValues, String id){
        receiver.insert_at(validatableValues, id);
    }
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
}
