package Commands;

import java.util.ArrayList;

public class ShowCommand implements CollectionableCommand {
    @Override
    public void execute(){
        receiver.show();
    }
    @Override
    public void describe(){
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String s){}
    @Override
    public void execute(ArrayList<String> validatableValues){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
    
}
