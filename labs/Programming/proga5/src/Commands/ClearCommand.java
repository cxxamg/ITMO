package Commands;

import java.util.ArrayList;

public class ClearCommand implements CollectionableCommand {
    @Override
    public void execute(String FilePath){
    }
    @Override
    public void describe(){
        System.out.println("clear : очистить коллекцию");
    }
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(){
        receiver.clear();
    }
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
