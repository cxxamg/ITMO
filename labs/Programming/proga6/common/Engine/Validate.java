package common.Engine;
import common.Entity.*;

/** 0 - exit
 * 1 - Все успешно
 * 2 - Invalid Format
 * 3 - Cant be null 
 * 4 - Неправильный диапазон числа*/

/**
 * Класс содержащий методы для валидации полей City
 * @author Alexander Sokolov
 * @version 1.0
 */
public class Validate{
    public static class AskBreak extends Exception {} 

    public static String validateName(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
           return "1";
        } else return "3";
    }


    public static String validateCoordinatesX(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")){
         try {Long.parseLong(input); return "1"; }catch(NumberFormatException e) {
            return "2";}
        }else{
            return "3";
        }
    }

    public static String validateCoordinatesY(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")){
         try {Float.parseFloat(input); return "1"; }catch(NumberFormatException e) {
            return "2";}
        }else{
            return "3";
        }
    }

    public static String validateArea(String input){
        float area;
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
            try {area = Float.parseFloat(input); 
                if (area > 0){
                    return "1";
                }else{
                    return "4";
                }
                
            }
            catch(NumberFormatException e) { return "2";}
        }  else {return "3";}
    }

    public static String validatePopulation(String input){
        int population;
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
            try { population = Integer.parseInt(input); 
                if (population > 0){
                    return "1";
                }else{
                    return "4";
                }
                
            }
            catch(NumberFormatException e) { return "2";}
        }  else {return "3";}
    }

    public static String validateMetersAboveSeaLevel(String input){
        int masl;
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")){
            try {masl = Integer.parseInt(input); 
                if (masl > 0){
                    return "1";
                }else{
                    return "4";
                } 
            }
            catch(NumberFormatException e) {
               return "2";}
           }else{
               return "3";
           }
    }

    public static String validateClimate(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
            try {
                Climate.valueOf(input); return "1";
            } catch (NullPointerException | IllegalArgumentException  e) {return "2"; }
        } else {return "3";}
    }

    public static String validateGovernment(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
            try {
                Government.valueOf(input); return "1";
            } catch (NullPointerException | IllegalArgumentException  e) {return "2"; }
        } else return "3";
    }

    public static String validateStandardOfLiving(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
            try {
                StandardOfLiving.valueOf(input); return "1";
            } catch (NullPointerException | IllegalArgumentException  e) {return "2"; }
        } else return "3";
    }

    public static String validateHuman(String input){
        if (input.equals("exit")){
            return "0";
        }
        if (!input.equals("")) {
           return "1";
        } else return "3";
    }
}