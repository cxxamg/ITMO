package Engine;

import java.util.*;
/**
 * Класс для работы с классом HistoryCommand
 * @author Alexander Sokolov
 * @version 1.0
 */
public class CommandHistory {
    private static final int MAX_HISTORY_SIZE = 9;
    private static final List<String> commandHistory = new LinkedList<>();
    
    /** Метод для добавления команды в историю 
     * @param command команда для добавления ее в историю
    */
    public static void addCommandToHistory(String command) {
        if (commandHistory.size() >= MAX_HISTORY_SIZE) {
            commandHistory.remove(0); 
        }
        commandHistory.add(command); 
    }

    /** Метод для вывода последних 9 команд */
    public static void printLastCommands() {
        System.out.println("Last 9 commands:");
        int count = 0;
        for (String command : commandHistory) {
            count++;
            System.out.println(count + ". "+command);  // Разделяем команду и её аргументы, выводим только название команды
        }
    }


}

