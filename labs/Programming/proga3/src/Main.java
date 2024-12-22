import Event.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();

        Animal wolf = new Animal("Волк",100,new Location(LocationType.FOREST), 50);
        Animal sheep = new Animal("Овца",100,new Location(LocationType.MOUNTAIN), 15);
        Animal horse = new Animal("Корова",100,new Location(LocationType.VILLAGE), 15);
        animals.add(wolf);
        animals.add(sheep);
        animals.add(horse);
        Item weapon = new Item("Дробовик", ItemType.WEAPON);
        Item apple = new Item("Яблоко", ItemType.FOOD);
        Item medicine = new Item("Аптечка", ItemType.MEDICINE);
        items.add(weapon);
        items.add(apple);
        items.add(medicine);
        Human mainChar = new Human("Путешественник", 100,new Location(LocationType.HOLLOW));
        Story str = new Story(items, animals, mainChar);
        str.go();
        
    }
}