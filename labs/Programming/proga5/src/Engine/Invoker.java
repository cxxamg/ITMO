package Engine;

import Commands.*;
import FileManager.*;
import java.util.Scanner;
/**
 * Класс для работы пользовательских команд
 * @author Alexander Sokolov
 * @version 1.0
 */
public class Invoker extends AbstractInvoker{

    public static Scanner sc = new Scanner(System.in);
    private static boolean isScannerClosed = false;
    private static WorkingMode workingMode = WorkingMode.INTERACTIVE;

    /**Установка другого режима работы консоли */
    public static void setWorkingMode(WorkingMode wm){
        workingMode = wm;
    }
    /**getter для режима работы */
    public static WorkingMode getWorkingMode(){
        return workingMode;
    }
    /**setter для режима работы */
    public static void setIsScannerClosed(boolean b){
        isScannerClosed = b;
    }

    /** Конструктор для добавления доп команды exit для пользовательского ввода */
    public Invoker(){
        super();
        this.commandz.put("exit", new ExitCommand());
    }

    /** Метод для начала работы консоли */
    public void console(){
        XmlReader.xml_read();
        System.out.println("Console has been launched. Use \"help\" to display help on available commands");
        while (!isScannerClosed) {
            try {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                // System.out.println(line);
                //System.out.println(Arrays.toString(tokens));
                Command command = this.commandz.get(tokens[0]);
                if (tokens.length != command.getValuesCount()) {
                    System.out.println("Incorrect command syntax. Incorrect count of values for \""+ tokens[0] +"\" command");
                } else {
                    CommandHistory.addCommandToHistory(tokens[0]);
                    if (command.getValuesCount() == 1){
                        command.execute(); 
                    }else{
                        command.execute(tokens[1]); 
                    }
                    //написать в конструкторе команд передаваемые аргументы если они есть
                }
            } catch (NullPointerException e){
                System.out.println("Command not found. Use \"help\" to display help on available commands");
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
