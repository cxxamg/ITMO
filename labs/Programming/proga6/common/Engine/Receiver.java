package common.Engine;
import common.Entity.City;
import common.FileManager.XmlWriter;
import java.util.Stack;
/**
 * Класс, содержащий коллекцию и методы для работы с ней
 * @author Alexander Sokolov
 * @version 1.0
 */
public class Receiver {
    public static Stack<City> stack = new Stack<>();

    public void add(City city){
        stack.add(city);
    } 

    public void remove(City city){
        stack.remove(city);
    }
    public void remove(){
        stack.remove(0);
    }

    public void clear(){
        stack.clear();
    }

    public int size(){
        return stack.size();
    }

    public static void save(){
        XmlWriter.xml_write(stack);
    }
}
