package Event;

import java.util.ArrayList;

public class Story {
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Animal> animalsMeetings = new ArrayList<>();
    Human mainChar;


    public Story(ArrayList<Item> items, ArrayList<Animal> animals, Human mainChar){
        this.items = items;
        this.animals = animals;
        this.mainChar = mainChar;
        this.animalsMeetings = animals;
    }

    public void go(){
        while (mainChar.getLocation().location() != LocationType.VILLAGE) {
            Animal curAnimal = new Animal("null", 100, new Location(LocationType.NOTEXIST), 0);
            for (Item item : items) {
                if (mainChar.getLocation().equals(item.getLocation())){
                    item.interact(mainChar);
                    try{
                    mainChar.addToInv(item);
                    }catch(InvalidCreatureHealthException e) { 
                        System.out.println(e.getMessage());
                    }
                }
            }
            for (Animal animal : animals) {
                    if (mainChar.getLocation().equals(animal.getLocation())){ //story class - локация чел и жив совпадает
                        System.out.println(mainChar.getName()+" встречает " + animal.getName());
                        try {
                        mainChar.interact(animal);
                        }catch(InvalidCreatureHealthException e) { //тут обработать чтобы завершало прогу
                            if (e.getMessage().contains(mainChar.getName()+" погиб!")) {
                                System.out.println("Ошибка: " + e.getMessage());
                                System.exit(1); 
                            }else{
                            System.out.println(e.getMessage());}
                        } animal.move();
                } 
            } for (Animal animal : animalsMeetings) {
                if (curAnimal.getLocation().equals(animal.getLocation())){
                    curAnimal.interact(animal);
                    curAnimal = animal;
                }
            }
            mainChar.move();
        }
        System.out.println("Наконец-то " + mainChar.getName() + " в деревне, где он решил заночевать" );
        mainChar.sleep();
    }

}
