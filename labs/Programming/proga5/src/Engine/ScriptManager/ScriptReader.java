package Engine.ScriptManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScriptReader {
    public static ArrayList<String> script_commands = new ArrayList<>();
    public static ArrayList<String> pathsRecursion = new ArrayList<>();

    public static void script_read(String FilePath){
        try(FileReader fr = new FileReader(FilePath)){ //try с ресурсами
            pathsRecursion.add(FilePath);
            StringBuilder cmdBuilder = new StringBuilder();
            int c;
            String line;
            while ((c = fr.read()) != -1) {
                if (c == 10){ //конец строки
                    line = cmdBuilder.toString(); //преобразовали много char в String
                    //System.out.println(line); //----
                    if (line.split("\\s+")[0].equals("execute_script")){ //проверка на рекурсию
                        if (pathsRecursion.contains(line.split("\\s+")[1])){
                            System.out.println("Recursion spotted. From " + FilePath + " to "+ line.split("\\s+")[1]);
                        } else { script_read(line.split("\\s+")[1]);}
                    } else {
                        script_commands.add(line);
                    } cmdBuilder.setLength(0); 
                    
                    
                } else {
                    cmdBuilder.append((char) c); //добавление в строку char
                }
            }

            if (cmdBuilder.length() > 0) { //проверка на рекурсию последней строки
                line = cmdBuilder.toString();
                if (line.split("\\s+")[0].equals("execute_script")){
                    if (pathsRecursion.contains(line.split("\\s+")[1])){
                        System.out.println("Recursion spotted. From " + FilePath + " to "+ line.split("\\s+")[1]);
                } else{
                    script_read(line.split("\\s+")[1]);
                }
                } else {
                    script_commands.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading a file: " + e.getMessage());
        }
        //System.out.println(pathsRecursion);
        //System.out.println(script_commands); //----
    }
    public static void clearScriptCommands(){
        script_commands.clear();
        pathsRecursion.clear();
    }

}
