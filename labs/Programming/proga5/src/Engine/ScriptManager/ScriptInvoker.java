package Engine.ScriptManager;

import Commands.Command;
import Commands.ExitCommand;
import Commands.Validatable;
import Engine.AbstractInvoker;
import Engine.Invoker;
import Engine.WorkingMode;
import java.util.ArrayList;

/**
 * Класс для работы команд из скрипта
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ScriptInvoker extends AbstractInvoker{
    private static boolean checkValidatableValues = false;
    private static final ArrayList<String> validatableValues = new ArrayList<>();
    private static Command curValidatableCommand;
    private static boolean isScriptScannerClosed = true;

    /** Конструктор для получения списка commandz */
    public ScriptInvoker(){
        super();
    }
    /**setter для поля проверки если скрипт закрыт */
    public static void setIsScriptScannerClosed(boolean b){
        isScriptScannerClosed = b;
    }
    /**getter для поля проверки если скрипт закрыт */
    public static boolean getIsScriptScannerClosed(){
        return isScriptScannerClosed;
    }
    /**Метод запуска validatable команд с одним параметром для сокращения кода */
    public static void executeAndReset(boolean cVV){
        checkValidatableValues = cVV;
        curValidatableCommand.execute(validatableValues);
        validatableValues.clear();
        if (AskScript.isExitBehindArgs){
            Command exit = new ExitCommand();
            exit.execute();
        }
    }
    /**Метод запуска validatable команд с двумя параметрами для сокращения кода */
    public static void execute2ArgsValidCmdAndReset(boolean cVV, String id){
        checkValidatableValues = cVV;
        curValidatableCommand.execute(validatableValues, id);
        validatableValues.clear();
        if (AskScript.isExitBehindArgs){
            Command exit = new ExitCommand();
            exit.execute();
        }
    }
    /**Запуск команд из скрипта
     * @param commands команда из скрипта
     */
    public void script_invoker(ArrayList<String> commands){
        isScriptScannerClosed = false;
        Invoker.setWorkingMode(WorkingMode.SCRIPT);
        int index = 0;
        int len = commands.size();
        String curToken = "";
        boolean isIt1ArgValidCmd = false;
        for (String line : commands){
            if (!isScriptScannerClosed){
                index++;
                try {
                    String[] tokens = line.split(" ");
                    Command command = this.commandz.get(tokens[0]);
                    if (tokens.length != command.getValuesCount()) { //если неправильная команда в потоке ввода validate cmd
                        if (checkValidatableValues){
                            validatableValues.add(line);
                        } else {
                            System.out.println("Incorrect count of values");
                        }
                    } else {
                        if (command.getValuesCount() == 1){
                            if (command instanceof Validatable){ //Validatable ADD только одно колво значений при вводе
                                if (checkValidatableValues){                  
                                    if (isIt1ArgValidCmd) {
                                        executeAndReset(true);
                                    } else {
                                        execute2ArgsValidCmdAndReset(true, curToken);
                                    }
                                    curValidatableCommand = command;
                                    isIt1ArgValidCmd = true;
                                }else{
                                    curValidatableCommand = command;
                                    isIt1ArgValidCmd = true;
                                } //другая команда валидативная и рабочая
                                checkValidatableValues = true;
                            } else { // команда не валидативная и РАБОЧАЯ
                                if (checkValidatableValues){
                                    if (isIt1ArgValidCmd) {
                                        executeAndReset(false);
                                    } else {
                                        execute2ArgsValidCmdAndReset(false, curToken);
                                    }
                                }
                                command.execute(); 
                            }
                        }else{
                            if (command instanceof Validatable){  //Validatable Update и Insert At 2 знач при вводе
                                if (checkValidatableValues){             
                                    //System.out.println("82 : scriptInvoker");     
                                    if (isIt1ArgValidCmd) {
                                        executeAndReset(true);
                                    } else {
                                        execute2ArgsValidCmdAndReset(true, curToken);
                                    }
                                    curValidatableCommand = command;
                                    isIt1ArgValidCmd = false;
                                    curToken = tokens[1];
                                }else{
                                    //System.out.println("86 : scriptInvoker " + curValidatableCommand); 
                                    curToken = tokens[1];  
                                    curValidatableCommand = command;
                                    isIt1ArgValidCmd = false;
                                } //другая команда валидативная и рабочая
                                checkValidatableValues = true;
                            } else {
                                if (checkValidatableValues){
                                    if (isIt1ArgValidCmd) {
                                        executeAndReset(false);
                                    } else {
                                        execute2ArgsValidCmdAndReset(false, curToken);
                                    }
                                }
                                command.execute(tokens[1]); 
                            }
                        }
                    }
                } catch (Exception e) {
                    //System.out.println(line + " "+ e.toString()); //для отселживания ошибок и неправильной работы
                    if (checkValidatableValues) { //здесь значения для Валидативной команды вписваются в arraylist
                        validatableValues.add(line.trim());
                        //System.out.println("102: ScriptInvoker " + validatableValues);
                        if (index == len){ //обработка, если line будет последним в массиве запросов
                            if (isIt1ArgValidCmd) {
                                executeAndReset(false);
                            } else {
                                execute2ArgsValidCmdAndReset(false, curToken);
                            }
                        }
                    } else if (line.trim().equals("exit")) {
                        Command exit = new ExitCommand();
                        exit.execute();
                    }
                    
                    }
            } else {
                break;
            }
            
        } Invoker.setWorkingMode(WorkingMode.INTERACTIVE);
    }
    
}

