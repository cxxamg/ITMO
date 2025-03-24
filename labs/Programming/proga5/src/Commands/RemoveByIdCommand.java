package Commands;

import java.util.ArrayList;

public class RemoveByIdCommand implements CollectionableCommand {
    @Override
    public void execute(String id){
        receiver.remove_by_id(id);
    }
    @Override
    public void describe(){
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
    }
    @Override
    public int getValuesCount(){
        return 2;
    }
    @Override
    public void execute(){
    }
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
