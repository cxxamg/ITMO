package FileManager;

import Engine.Ask;
import Engine.Receiver;
import Engine.ScriptManager.AskScript;
import Entity.City;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;

public class XmlReader implements XmlFilePathInterface{
    private static boolean isCreationDateUnchecked = false;
    private static String curCreationDate;

    public static String getCurCreationDate(){
        return curCreationDate;
    }

    public static void setIsCreationDateUnchecked(boolean b){
        isCreationDateUnchecked = b;
    }

    public static boolean getIsCreationDateUnchecked(){
        return isCreationDateUnchecked;
    }


    public static void xml_read(){
        ArrayList<String> validatableValues = new ArrayList<>();
        ArrayList<String> recentValidatableTags = new ArrayList<>();
        String curTag = "";


        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(XMLPATH));
            while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartElement()) {
                if (event.asStartElement().getName().toString().equals("city")){
                    cityCreaturing(validatableValues, recentValidatableTags);
                } else {
                    curTag = event.asStartElement().getName().toString();
                }
            } else if (event.isCharacters()) {
                    String value = event.asCharacters().getData().trim();
                
                    if (!curTag.isEmpty()) {
                        // creationDate обрабатываем отдельно
                        if (curTag.equals("creationDate")) {
                            isCreationDateUnchecked = true;
                            curCreationDate = value;
                        } else {
                            // Если поле пустое, то записываем "",для government и human
                            
                             if (!value.isEmpty()) {
                                validatableValues.add(value);
                                recentValidatableTags.add(curTag);
                             }
                        }
                    }
                
                    // Выводим только значимые теги
                    // if (!curTag.isEmpty()) {
                    //     System.out.println("[" + curTag + "]: '" + value + "'");
                    // }
                

            }  else if (event.isEndElement()) {
                String closedTag = event.asEndElement().getName().getLocalPart();
                if (curTag.equals("government") && !recentValidatableTags.contains("government")) {
                    validatableValues.add("");
                }
                if (curTag.equals("human") && !recentValidatableTags.contains("human")) {
                    validatableValues.add("");
                }
                if (closedTag.equals(curTag)) {
                    curTag = "";
                }
            }
        }   cityCreaturing(validatableValues, recentValidatableTags);
            reader.close();
            //System.out.println(validatableValues + "dsds");
            }catch (FileNotFoundException e) {  
            System.out.println("XML file not found! Check path: " + XMLPATH);
            } catch (XMLStreamException e) {  
                System.out.println("XML processing error:: " + e.getMessage());
            }  catch (Exception e) {  
                System.out.println("Unknown error: " + e.getMessage());
            }
        } 
        

        static void cityCreaturing(ArrayList<String> validatableValues, ArrayList<String> alreadyValidatableTags){
            if (!validatableValues.isEmpty()){
                City city = null;
                try {
                    city = AskScript.askCity(validatableValues);
                } catch (Ask.AskBreak e) {
                    System.out.println("City isn't created");
                    isCreationDateUnchecked = false;
                }
                if (city != null){
                    Receiver.stack.add(city);
                }
                validatableValues.clear();
                alreadyValidatableTags.clear();
            } 
        }
}

