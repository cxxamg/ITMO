package Client;
import Client.ScriptManager.ScriptInvoker;
import Client.ScriptManager.ScriptReader;
import common.Commands.*;
import common.Engine.*;
import common.Entity.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/**
 * Класс для работы пользовательских команд
 * @author Alexander Sokolov
 * @version 1.0
 */
public class ClientInvoker extends AbstractInvoker{

    public static Scanner sc = new Scanner(System.in);
    private static boolean isScannerClosed = false;
    private static WorkingMode workingMode = WorkingMode.INTERACTIVE;
    public static Socket sock = null;
    public static OutputStream os = null; 
    public static InputStream is;

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
    public ClientInvoker(){
        super();
        this.commandz.put("exit", new ExitCommand());
    }

    /** Метод для начала работы консоли */
    public void console(){
        sock = ClientConnection.connect("localhost", 3928);
        try {
            os = sock.getOutputStream();    
            is = sock.getInputStream();
            System.out.println("Client Console has been launched. Use \"help\" to display help on available commands");
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
                        //CommandHistory.addCommandToHistory(tokens[0]);
                        if (command.getValuesCount() == 1){
                            if (command instanceof Validatable){ //add
                                CityImport city = null;
                                try{
                                city = Ask.askCityImport();
                                }   catch (Ask.AskBreak e) {}
                                if (city != null){
                                    CommandResponce cmdRes = new CommandResponce(command, null, city, 0);
                                    ClientSendNRead.serializeAndSend(cmdRes, os);
                                    ClientSendNRead.unserializeAndRead(is);
                                }
                            } else{
                                if (command instanceof ExitCommand){
                                    System.out.println("Exiting");
                                    isScannerClosed = true;
                                } else {
                                    CommandResponce cmdRes = new CommandResponce(command,null, null, 1);
                                    ClientSendNRead.serializeAndSend(cmdRes, os);
                                    ClientSendNRead.unserializeAndRead(is);
                                }
                            }
                            //command.execute(); 
                        }else{
                            if (command.parseValue(tokens[1])){
                                if (command instanceof Validatable){ //update, insert_at
                                    CityImport city = null;
                                    try{
                                    city = Ask.askCityImport();
                                    }   catch (Ask.AskBreak e) {}
                                    if (city != null){
                                        CommandResponce cmdRes = new CommandResponce(command, tokens[1], city, 2);
                                        ClientSendNRead.serializeAndSend(cmdRes, os);
                                        ClientSendNRead.unserializeAndRead(is);
                                    }
                                } else{
                                    if (command instanceof ExecuteScriptCommand){
                                        //System.out.println("exe");
                                        ScriptReader.script_read(tokens[1]);
                                        ScriptInvoker sI = new ScriptInvoker();
                                        sI.script_invoker(ScriptReader.script_commands);
                                        ScriptReader.clearScriptCommands();
                                    } else {
                                        CommandResponce cmdRes = new CommandResponce(command,tokens[1], null, 3);
                                        ClientSendNRead.serializeAndSend(cmdRes, os);
                                        ClientSendNRead.unserializeAndRead(is);
                                    }
                                }
                            }
                            //command.execute(tokens[1]); 
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
        } catch (IOException e) {
            System.out.println("Ошибка создания потоков client");
            System.exit(1);
        }

        
    }

    // public static void serializeAndSend(CommandResponce cmdRes, OutputStream os){
    //     byte[] serializedCmdRes = Serializer.serialize(cmdRes);
    //     try {
    //         os.write(serializedCmdRes);
    //     } catch (SocketException e){
    //         System.out.println("Сервер отключился во время отправки команды");
    //         System.exit(1); 
    //     } catch (IOException e) {
    //         System.out.println("Ошибка при отправлении на Client");
    //         System.exit(1); 
    //     }
    // }
    
    // public static void unserializeAndRead(InputStream is){
    //     byte[] data = new byte[20000];
    //     try {
    //         is.read(data);
    //     } catch (IOException e) {
    //         System.out.println("Ошибка при чтении на Client");
    //         System.out.println("Сервер отключен");
    //         System.exit(1); 
    //     }
    //     Object obj = Serializer.deserialize(data);
    //     if (obj != null) {
    //         if (obj instanceof ExecutionResponce) {
    //             ExecutionResponce exRes = (ExecutionResponce) obj;
    //             System.out.println("Получен ответ от сервера: " + exRes.message());
    //         } else {
    //             System.out.println(obj.toString());
    //         }
    //     } else {
    //         System.out.println("Ошибка при десериализации объекта");
    //     }
    // }
}
