package Commands;
import Engine.Invoker;
import Engine.ScriptManager.ScriptInvoker;
import Engine.WorkingMode;
import java.util.ArrayList;
/**
 * Класс команды для выхода из программы
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ExitCommand implements Command{
    /**Реализация команды */
    @Override
    public void execute(){
        WorkingMode wM = Invoker.getWorkingMode();
        if (wM == WorkingMode.INTERACTIVE){
            System.out.println("Exiting...");
            Invoker.setIsScannerClosed(true);
        } else{
            System.out.println("Exiting from script...");
            ScriptInvoker.setIsScriptScannerClosed(true);
        }
    }
    @Override
    /** Описание команды */
    public void describe(){
        System.out.println("exit : завершить программу (без сохранения в файл)");
    }
    /** Кол-во элементов команды */
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
