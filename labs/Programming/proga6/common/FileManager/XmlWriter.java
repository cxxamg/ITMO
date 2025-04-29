package common.FileManager;

import common.Entity.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Logger;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
/**
 * Класс для написания Xml файла из Stack
 * @author Alexander Sokolov
 * @version 1.0
 */
public class XmlWriter implements XmlFilePathInterface{
    /** Написание нового Xml Файла
     * @param stack коллекция из которой будет писаться новый Xml файл
    */
    private static final Logger logger = Logger.getLogger(XmlReader.class.getName());
    public static void xml_write(Stack<City> stack){
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLEventWriter writer = outputFactory.createXMLEventWriter(new FileWriter(XMLPATH));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            XMLEvent event = eventFactory.createStartDocument(); //начало документа
            writer.add(event);
            writer.add(eventFactory.createCharacters("\n"));
            writer.add(eventFactory.createStartElement("", "", "cities"));

            for (int i = 0; i < stack.size(); i++) {
                City c = stack.get(i);
                var name = c.getName();
                var coordinatesX = c.getCoordinates().getX() + "";
                var coordinatesY = c.getCoordinates().getY() + "";
                var creationDate = c.getCreationDate() + "";
                var area = c.getArea() + "";
                var population = c.getPopulation() + "";
                var metersAboveSeaLevel = c.getMetersAboveSeaLevel() + "";
                var climate = c.getClimate() + "";
                String government;
                if (c.getGovernment() != null){
                    government = c.getGovernment() + "";
                }else{
                    government = "";
                }
                var standardOfLiving = c.getStandardOfLiving() + "";
                String human;
                if (c.getHuman() != null){
                    human = c.getHuman().getName();
                } else{
                    human = "";
                }
                //System.out.println(government + human);
                writer.add(eventFactory.createCharacters("\n"));
                writer.add(eventFactory.createCharacters("\t"));
                writer.add(eventFactory.createStartElement("", "", "city"));

                writer.add(eventFactory.createCharacters("\n"));
                writeElement(writer, eventFactory, "name", name,2);

                writeCoordinates(writer, eventFactory, 2, coordinatesX, coordinatesY);

                writeElement(writer, eventFactory, "creationDate", creationDate,2);
                writeElement(writer, eventFactory, "area", area,2);
                writeElement(writer, eventFactory, "population", population,2);
                writeElement(writer, eventFactory, "metersAboveSeaLevel", metersAboveSeaLevel,2);
                writeElement(writer, eventFactory, "climate", climate,2);
                writeElement(writer, eventFactory, "government", government,2);
                writeElement(writer, eventFactory, "standardOfLiving", standardOfLiving,2);
                writeElement(writer, eventFactory, "human", human,2);

                writer.add(eventFactory.createCharacters("\t"));
                writer.add(eventFactory.createEndElement("", "", "city"));
            }


            writer.add(eventFactory.createCharacters("\n"));
            event = eventFactory.createEndElement("", "", "cities");
            writer.add(event);

            // Завершаем документ
            event = eventFactory.createEndDocument();
            writer.add(event);

            // Закрываем writer
            writer.close();
            logger.info("XML file was successfully written.");
        } catch (FileNotFoundException e) {  
            logger.info("XML file not found! Check path: " + XMLPATH);
            } catch (XMLStreamException e) {  
                logger.info("XML processing error:: " + e.getMessage());
            } catch (IOException e){
                logger.info(e.getMessage());
            }
            catch (Exception e) {  
                logger.info("Unknown error: " + e.getMessage());
            }
    }
    /** метод для сокращения кода, который пишет одно поле в Xml */
    static void writeElement(XMLEventWriter writer, XMLEventFactory eventFactory, String tagName, String value, int tab) throws XMLStreamException{
        writer.add(eventFactory.createCharacters("\t".repeat(tab)));
        writer.add(eventFactory.createStartElement("", "", tagName));
        writer.add(eventFactory.createCharacters(value));
        writer.add(eventFactory.createEndElement("", "", tagName));
        writer.add(eventFactory.createCharacters("\n"));
    }
    /** метод для сокращения кода, который пишет именно Coordinates поле в Xml */
    static void writeCoordinates(XMLEventWriter writer, XMLEventFactory eventFactory, int tab, String coordinatesX, String coordinatesY) throws XMLStreamException{
        writer.add(eventFactory.createCharacters("\t".repeat(tab)));
        writer.add(eventFactory.createStartElement("", "", "coordinates"));
        writer.add(eventFactory.createCharacters("\n"));
        writeElement(writer, eventFactory, "x", coordinatesX,3);
        writeElement(writer, eventFactory, "y", coordinatesY,3);
        writer.add(eventFactory.createCharacters("\t".repeat(tab)));
        writer.add(eventFactory.createEndElement("", "", "coordinates"));
        writer.add(eventFactory.createCharacters("\n"));
    }
}