package Commands;

import java.util.ArrayList;

public class RemoveFirstCommand implements CollectionableCommand{
    @Override
    public void execute(){
        receiver.remove_first();
    }
    @Override
    public void describe(){
        System.out.println("remove_first : удалить первый элемент из коллекции");
    }
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String s){}
    @Override
    public void execute(ArrayList<String> args){
    }
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
