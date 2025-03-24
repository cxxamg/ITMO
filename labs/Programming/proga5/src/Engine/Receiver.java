package Engine;
import Engine.ScriptManager.AskScript;
import Engine.ScriptManager.ScriptInvoker;
import Engine.ScriptManager.ScriptReader;
import Entity.City;
import FileManager.XmlWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Receiver {
    public static Stack<City> stack = new Stack<>();

    public static void history(){
        CommandHistory.printLastCommands();
    }

    public void max_by_meters_above_sea_level(){
        int maxEl = 0;
        // for (int i = 0; i < stack.size(); i++) {
        //     if (maxEl < stack.get(i))
        // }
    }

    public void add(){
        City city = null;
        boolean isIdNotBusy = true;
        try{
        city = Ask.askCity();
        }   catch (Ask.AskBreak e) {
        
        }
        //var city = new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly"));
        if (city != null){
            for (int i = 0; i < stack.size(); i++) {
                if (city.getId() == stack.get(i).getId()){
                    isIdNotBusy = false;
                }
            }
            if (isIdNotBusy){
                stack.add(city);
            }else{
                city.setId(city.getId()+1);
                Ask.setCityCount(Ask.getCityCount()+1);
                stack.add(city);
            }
            System.out.println("City id=" + city.getId() + " is created");
            }
        //System.out.println("Стек: " + stack);
    } 
    
    public void add(ArrayList<String> validatableValues){
        //System.out.println(validatableValues);
        boolean isIdNotBusy = true;
        City city = null;
        try {
            city = AskScript.askCity(validatableValues);
        } catch (Ask.AskBreak e) {
            System.out.println("City isn't updated");
        }
        if (city != null){
            for (int i = 0; i < stack.size(); i++) {
                if (city.getId() == stack.get(i).getId()){
                    isIdNotBusy = false;
                }
            }
            if (isIdNotBusy){
                stack.add(city);
            }else{
                city.setId(city.getId()+1);
                Ask.setCityCount(Ask.getCityCount()+1);
                stack.add(city);
            }
            System.out.println("City id=" + city.getId() + " is created");
            }
    }

    public void insert_at(ArrayList<String> validatableValues, String idStr){
        //System.out.println("44 : receiver");
        long id;
        boolean found = false;
        City city = null;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < stack.size(); i++) {
                    if (id == stack.get(i).getId()){
                        try {
                            city = AskScript.askCity(validatableValues);
                            Ask.setCityCount(Ask.getCityCount()-1);
                        } catch (Ask.AskBreak e) {
                            System.out.println("City isn't inserted at collection");
                            found = true;
                        }
                        if (city != null){
                            city.setId(id);
                            stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    try {
                        city = AskScript.askCity(validatableValues);
                        Ask.setCityCount(Ask.getCityCount()-1);
                    } catch (Ask.AskBreak e) {
                        System.out.println("City isn't inserted at collection");
                    }
                    if (city != null){
                        city.setId(id);
                        stack.add(city);
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't deleted");
            } catch (Exception e) {
                System.out.println("City isn't deleted: " + e.toString());
            }
    }
    public void insert_at(String idStr){
        long id;
        boolean found = false;
        City city = null;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < stack.size(); i++) {
                    if (id == stack.get(i).getId()){
                        try{
                        city = Ask.askCity();
                        }   catch (Ask.AskBreak e) {
                            System.out.println("City isn't inserted at collection");
                        }
                        //var city = new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly"));
                        if (city != null){
                            city.setId(id);
                            stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    try {
                        city = Ask.askCity();
                        Ask.setCityCount(Ask.getCityCount()-1);
                    } catch (Ask.AskBreak e) {
                        System.out.println("City isn't inserted at collection");
                    }
                    if (city != null){
                        city.setId(id);
                        stack.add(city);
                    }
                }
            } catch (NoSuchElementException e){
                System.out.println("No such element in stack");
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't deleted");
            } catch (Exception e) {
                System.out.println("City isn't deleted: " + e.toString());
            }
    }

    public void update(ArrayList<String> validatableValues, String idStr){
        //System.out.println("44 : receiver");
        long id;
            boolean found = false;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < stack.size(); i++) {
                    if (id == stack.get(i).getId()){
                        City city = null;
                        try {
                            city = AskScript.askCity(validatableValues);
                            Ask.setCityCount(Ask.getCityCount()-1);
                        } catch (Ask.AskBreak e) {
                            System.out.println("City isn't updated");
                            found = true;
                        }
                        if (city != null){
                            city.setId(id);
                            stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e){
                System.out.println("No such element in stack" + e.toString());
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't deleted");
            } catch (Exception e) {
                System.out.println("City isn't deleted: " + e.toString());
            }
    }

    public void update(String idStr){
            long id;
            boolean found = false;
            try {
                id = Long.parseLong(idStr);
                for (int i = 0; i < stack.size(); i++) {
                    if (id == stack.get(i).getId()){
                        City city = null;
                        try{
                        city = Ask.askCity();
                        }   catch (Ask.AskBreak e) {
                        
                        }
                        //var city = new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly"));
                        if (city != null){
                            city.setId(id);
                            stack.set(i, city);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found){
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e){
                System.out.println("No such element in stack");
            } catch (NumberFormatException e){
                System.out.println("Error while parsing id. City isn't deleted");
            } catch (Exception e) {
                System.out.println("City isn't deleted: " + e.toString());
            }
        
    }


    public void remove_by_id(String idStr){
        int id;
        boolean found = false;
        try {
            id = Integer.parseInt(idStr);
            for (int i = 0; i < stack.size(); i++) {
                if (id == stack.get(i).getId()){
                    stack.remove(stack.get(i));
                    found = true;
                    break;
                }
            }
            if (!found){
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e){
            System.out.println("No such element in stack");
        } catch (NumberFormatException e){
            System.out.println("Error while parsing id. City isn't deleted");
        } catch (Exception e) {
            System.out.println("City isn't deleted: " + e.toString());
        }
    }

    public void clear(){
        stack.clear();
    }

    public void show(){
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }

    public void remove_first(){
        try {
            stack.remove(0);
        } catch (Exception e) {
            System.out.println("Collection items are out of stock: " + e.toString());
        }
    }

    public void save(){
        XmlWriter.xml_write(stack);
    }
    
    public static void exit(WorkingMode wM){
        if (wM == WorkingMode.INTERACTIVE){
            System.out.println("Exiting...");
            Invoker.setIsScannerClosed(true);
        } else{
            System.out.println("Exiting from script...");
            ScriptInvoker.setIsScriptScannerClosed(true);
        }
    }

    public static void execute_script(String FilePath){
        ScriptReader.script_read(FilePath);
        System.out.println("171 : receiver script commands: " + ScriptReader.script_commands);
        ScriptInvoker sI = new ScriptInvoker();
        sI.script_invoker(ScriptReader.script_commands);
        ScriptReader.clearScriptCommands();
    }

}
