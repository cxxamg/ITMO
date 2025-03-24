package Commands;

import java.util.ArrayList;

public class SaveCommand implements CollectionableCommand{
    @Override
    public void execute(){
        receiver.save();
    }
    @Override
    public void describe(){
        System.out.println("save : сохранить коллекцию в файл");
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
