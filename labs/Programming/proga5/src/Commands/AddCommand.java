package Commands;

import java.util.ArrayList;

public class AddCommand implements CollectionableCommand, Validatable{
    @Override
    public void execute(){
        receiver.add();
    }
    @Override
    public void describe(){
        System.out.println("add {element} : добавить новый элемент в коллекцию");
    }
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String s){}
    @Override
    public void execute(ArrayList<String> validatableValues){
        receiver.add(validatableValues);
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
