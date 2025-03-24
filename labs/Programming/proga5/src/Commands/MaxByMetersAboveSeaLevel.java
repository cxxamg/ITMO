package Commands;

import java.util.ArrayList;

public class MaxByMetersAboveSeaLevel implements CollectionableCommand {
    @Override
    public void execute(){
        receiver.max_by_meters_above_sea_level();
    }
    @Override
    public void describe(){
        System.out.println("max_by_meters_above_sea_level : вывести любой объект из коллекции, значение поля metersAboveSeaLevel которого является максимальным");
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
