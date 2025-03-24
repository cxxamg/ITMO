import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Engine.Invoker;
import Entity.*;

public class Main {
    static List<City> cities = new ArrayList<City>();
    public static void main(String[] args) {
        cities.add(new City(1L, "SPB", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly")));
        cities.add(new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly")));
        var city = new City(1L, "MSK", new Coordinates(10, (float) 0.2), LocalDate.now(), 0.3f, 100,100,Climate.MONSOON, Government.CORPORATOCRACY, StandardOfLiving.NIGHTMARE, new Human("Polly"));
        //for (var e: cities) System.out.println(e);
        //Command command = new AddCommand();
        //command.execute(city);
        Invoker invoker = new Invoker();
        invoker.console(); 
    }
}