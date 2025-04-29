package common.Engine;
import common.Entity.*;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * Класс для валидации пользовательских значений
 * @author Alexander Sokolov
 * @version 1.0
 */
public class Ask {
    public static class AskBreak extends Exception {}
    static Scanner sc = new Scanner(System.in);
    private static long cityCount = 0;

    /**setter для подсчета index for City */
    public static void setCityCount(long l){
        cityCount = l;
    }
    /**getter для подсчета index for City */
    public static long getCityCount(){
        return cityCount;
    }

    /**Validaция City
     * @throws AskBreak в случае неудачи при валидации
     */
    public static City askCity() throws AskBreak{
            System.out.println("* City Creaturing *");
            var cityIndex = cityCount;
            cityCount++;
            var name = askName();
            var coordinates = askCoordinates();
            var area = askArea();
            var population = askPopulation();
            var metersAboveSeaLevel = askMetersAboveSeaLevel();
            var climate = askClimate();
            var government = askGovernment();
            var standardOfLiving = askStandardOfLiving();
            var human = askHuman();
            return new City(cityIndex, name, coordinates, LocalDate.now(), area, population, metersAboveSeaLevel, climate, government, standardOfLiving, human);
        }
        
    public static City convertCityImportIntoCity(CityImport c) throws AskBreak{
        var cityIndex = cityCount;
            cityCount++;
            var name = c.getName();
            var coordinates = c.getCoordinates();
            var area = c.getArea();
            var population = c.getPopulation();
            var metersAboveSeaLevel = c.getMetersAboveSeaLevel();
            var climate = c.getClimate();
            var government = c.getGovernment();
            var standardOfLiving = c.getStandardOfLiving();
            var human = c.getHuman();
            return new City(cityIndex, name, coordinates, LocalDate.now(), area, population, metersAboveSeaLevel, climate, government, standardOfLiving, human);
    }

    public static CityImport askCityImport() throws AskBreak{
        System.out.println("* City Creaturing *");
            var name = askName();
            var coordinates = askCoordinates();
            var area = askArea();
            var population = askPopulation();
            var metersAboveSeaLevel = askMetersAboveSeaLevel();
            var climate = askClimate();
            var government = askGovernment();
            var standardOfLiving = askStandardOfLiving();
            var human = askHuman();
            return new CityImport(name, coordinates, area, population, metersAboveSeaLevel, climate, government, standardOfLiving, human);
    }

    public static String askName() throws AskBreak{
        String name = null;
        while(true){
            System.out.print("name: ");
            var input = sc.nextLine();
            switch (Validate.validateName(input)){
                case "0" -> throw new AskBreak();
                case "1" -> {name = input; break;}
                case "3" -> {System.out.println("Name can't be null. Try again!"); continue;}
            }
            break;
        } return name;
    }


    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static Coordinates askCoordinates() throws AskBreak{
        long x = 0;
        while(true) {
            System.out.print("coordinates.x: ");
            var input = sc.nextLine().trim();
            switch (Validate.validateCoordinatesX(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {x = Long.parseLong(input); break;}
                case "2" -> {System.out.println("Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("coordinates.x can't be null. Try again!"); continue;}
            }
            break;
        }
        float y = 0.0f;
            while (true) {
            System.out.print("coordinates.y: ");
            var input = sc.nextLine().trim();
            switch (Validate.validateCoordinatesY(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {y = Float.parseFloat(input); break;}
                case "2" -> {System.out.println("Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("coordinates.x can't be null. Try again!"); continue;}
            }
            break;
        } return new Coordinates(x, y);

    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static float askArea() throws AskBreak{
        float area = 0.0f;
        while (true) {
            System.out.print("area: ");
            var input = sc.nextLine().trim();
            switch (Validate.validateArea(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {area = Float.parseFloat(input); break;}
                case "2" -> {System.out.println("Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("Area can't be null. Try again!"); continue;}
                case "4" -> {System.out.println("Area must be greater than zero! Please try again!"); continue;}
            }
            break;
        }
        return area;
    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static int askPopulation() throws AskBreak{
        int population = 0;
        while (true) {
            System.out.print("population: ");
            var input = sc.nextLine().trim();
            switch (Validate.validatePopulation(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {population = Integer.parseInt(input); break;}
                case "2" -> {System.out.println("Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("Population can't be null. Try again!"); continue;}
                case "4" -> {System.out.println("Population must be greater than zero! Please try again!"); continue;}
            }
            break;
        }
        return population;
    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static int askMetersAboveSeaLevel() throws AskBreak{
        int metersAboveSeaLevel = 0;
        while (true) {
            System.out.print("metersAboveSeaLevel: ");
            var input = sc.nextLine().trim();
            switch (Validate.validateMetersAboveSeaLevel(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {metersAboveSeaLevel = Integer.parseInt(input); break;}
                case "2" -> {System.out.println("Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("MetersAboveSeaLevel can't be null. Try again!"); continue;}
                case "4" -> {System.out.println("MetersAboveSeaLevel must be greater than zero! Please try again!"); continue;}
            }
            break; 
        }
        return metersAboveSeaLevel;
    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static Climate askClimate() throws AskBreak {
        Climate climate = null;
        while (true) {
            System.out.print("climate ("+Climate.names()+"): ");
            var input = sc.nextLine().trim();
            switch (Validate.validateClimate(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {climate = Climate.valueOf(input); break;}
                case "2" -> {System.out.println("No such climate. Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("Climate can't be null. Try again!"); continue;}
            }
            break; 
        } return climate;
    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static Government askGovernment() throws AskBreak {
        Government government = null;
        while (true) {
            System.out.print("government ("+Government.names()+"): ");
            var input = sc.nextLine().trim();
            switch (Validate.validateGovernment(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {government = Government.valueOf(input); break;}
                case "2" -> {System.out.println("No such government. Invalid format. Please try again!"); continue;}
                case "3" -> {government = null; break;}
            }
            break;
        } return government;
    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static StandardOfLiving askStandardOfLiving() throws AskBreak {
        StandardOfLiving standardOfLiving = null;
        while (true) {
            System.out.print("standartOfLiving ("+StandardOfLiving.names()+"): ");
            var input = sc.nextLine().trim();
            switch (Validate.validateStandardOfLiving(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {standardOfLiving = StandardOfLiving.valueOf(input); break;}
                case "2" -> {System.out.println("No such standardOfLiving. Invalid format. Please try again!"); continue;}
                case "3" -> {System.out.println("StandardOfLiving can't be null. Try again!"); continue;}
            }
            break; 
        } return standardOfLiving;
    }
    /**Validaция поля 
     * @throws AskBreak в случае неудачи при валидации
     */
    public static Human askHuman() throws AskBreak{
        Human human = null;
        String name = null;
        while (true){
            System.out.print("name of governer: ");
            var input = sc.nextLine();
            switch (Validate.validateHuman(input)) {
                case "0" -> throw new AskBreak();
                case "1" -> {name = input; break;}
                case "3" -> {return human;}
            }
            break; 
        } return new Human(name);     
            }
}
        
     

