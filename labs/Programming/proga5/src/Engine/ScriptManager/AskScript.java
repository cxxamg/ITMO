package Engine.ScriptManager;
import Engine.*;
import Entity.*;
import FileManager.XmlReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/**
 * Класс для валидации значений из скрипта для создания City обьекта
 * @author Alexander Sokolov
 * @version 1.0
 */
public class AskScript {
    /**Находиться ли Exit команда за другими arguments для City */
    public static boolean isExitBehindArgs = false;

    /**Список для хранения методов Validate */
    static List<Function<String, String>> validators = List.of(
    Validate::validateName,
    Validate::validateCoordinatesX, //вместо input -> Validate.validateCoordinatesX(input)
    Validate::validateCoordinatesY, 
    Validate::validateArea,
    Validate::validatePopulation,
    Validate::validateMetersAboveSeaLevel,
    Validate::validateClimate,
    Validate::validateGovernment,
    Validate::validateStandardOfLiving,
    Validate::validateHuman
);

    /** Валидация City из скрипта
     * @param validatableValues значения для валидации
     * @return city - обьект
     * @throws AskBreak при неверных данных и других ошибках
     */
    public static City askCity(ArrayList<String> validatableValues) throws Ask.AskBreak{
        long cityIndex = 0;
        String name = null;
        Coordinates coordinates = null;
        float area = 0.0f;
        int population = 0;
        int metersAboveSeaLevel = 0;
        Climate climate = null;
        Government government = null;
        StandardOfLiving standardOfLiving = null;
        Human human = null;
        LocalDate localDate = null;

        String[] validatedValues = new String[10];
        if (validatableValues.size() < 10){
            System.out.println("Not enough args for creaturing City type: " + validatableValues.toString());
            throw new Ask.AskBreak();
        } else {
            int validatorIndex = 0;
            //System.out.println(validatableValues + " 121221"); 
            for (String input: validatableValues){
                    if (validatorIndex < 10){
                        Function<String, String> validator = validators.get(validatorIndex);
                        if (validatorIndex != 7 && validatorIndex != 9){     // для government и human которые могут быть null
                            if (validator.apply(input).equals("1")){
                                validatedValues[validatorIndex] = input;
                                validatorIndex++;
                        
                            } else if (validator.apply(input).equals("0")){
                                System.out.println("exit is found in City's args");
                                isExitBehindArgs = checkIfExitBehindArgs(validatableValues, validatedValues);   
                                throw new Ask.AskBreak();
                            }
                        } else{
                            if (validator.apply(input).equals("1") || validator.apply(input).equals("3")){
                                validatedValues[validatorIndex] = input;
                                validatorIndex++;
            
                            } else if (validator.apply(input).equals("0")){
                                System.out.println("exit is found in City's args");
                                isExitBehindArgs = checkIfExitBehindArgs(validatableValues, validatedValues);   
                                throw new Ask.AskBreak();
                            }
                        }
                    } else {
                        break;
                    }
            }       
        
            isExitBehindArgs = checkIfExitBehindArgs(validatableValues, validatedValues);    
            checkIfArrayHasEnoughValidArgs(validatedValues);

            //System.out.println(Arrays.toString(validatedValues));
            cityIndex = Ask.getCityCount();
            name = validatedValues[0];
            coordinates = new Coordinates(Long.parseLong(validatedValues[1]), Float.parseFloat(validatedValues[2]));
            area = Float.parseFloat(validatedValues[3]);
            population = Integer.parseInt(validatedValues[4]);
            metersAboveSeaLevel = Integer.parseInt(validatedValues[5]);
            climate = Climate.valueOf(validatedValues[6]);
            if (validatedValues[7].equals("")){government = null;
            } else {
                government = Government.valueOf(validatedValues[7]);
            }
            standardOfLiving = StandardOfLiving.valueOf(validatedValues[8]);
            if (validatedValues[9].equals("")){human = null;
            } else {human = new Human(validatedValues[9]);}

            if (XmlReader.getIsCreationDateUnchecked()){
                //System.out.println("HERE LOCAL TIME 1");
                try {
                    localDate = LocalDate.parse(XmlReader.getCurCreationDate());
                    XmlReader.setIsCreationDateUnchecked(false);
                } catch (Exception e) {
                    throw new Ask.AskBreak();
                }
            } else {
                //System.out.println("HERE LOCAL TIME 2");
                localDate = LocalDate.now();
            }

            //System.out.println("110 : AskScript " + cityIndex);
            Ask.setCityCount(Ask.getCityCount()+1);

        
        
    } return new City(cityIndex, name, coordinates, localDate, area, population, metersAboveSeaLevel, climate, government, standardOfLiving, human);
    }

    /**Метод для сокращения кода */
    static boolean checkIfExitBehindArgs(ArrayList<String> validatableValues, String[] validatedValues) {
        ArrayList<String> behindValues = new ArrayList<>(validatableValues);
        behindValues.removeAll(Arrays.asList(validatedValues));
        //System.out.println(behindValues); 
        return behindValues.contains("exit");
    }

    /**Метод для сокращения кода */
    static void checkIfArrayHasEnoughValidArgs(String[] validatedValues) throws Ask.AskBreak{
        for (int i = 0; i < validatedValues.length; i++){
            if (i != 7 && i != 9){
                if (validatedValues[i] == null || validatedValues[i].equals("")){
                    System.out.println("Not enough validated args for creaturing City type: " + Arrays.toString(validatedValues));
                    throw new Ask.AskBreak();
                }
            }
        } 
    }


}
