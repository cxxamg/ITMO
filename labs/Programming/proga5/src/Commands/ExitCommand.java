package Commands;
import Engine.Invoker;
import Engine.Receiver;
import java.util.ArrayList;

public class ExitCommand implements Command{
    @Override
    public void execute(){
        Receiver.exit(Invoker.getWorkingMode());
    }
    @Override
    public void describe(){
        System.out.println("exit : завершить программу (без сохранения в файл)");
    }
    @Override
    public int getValuesCount(){
        return 1;
    }
    @Override
    public void execute(String arg){}
    @Override
    public void execute(ArrayList<String> arg){}
    @Override
    public void execute(ArrayList<String> arg,String id){}
}
