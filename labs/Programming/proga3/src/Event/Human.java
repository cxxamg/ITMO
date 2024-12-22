package Event;

import java.util.ArrayList;

public class Human extends Creature {
    protected ArrayList<Item> inventory = new ArrayList<>();
    protected boolean hasWeapon = false;

    public Human(String name, int health, Location location){
        this.name = name;
        this.health = health;
        this.location = location;
        System.out.println("В локации " + this.location.location().getTranslate() + " начинает свой путь " + this.name);
    }

    @Override 
    public void interact(Animal animal){
        if (animal.getAggressive() > 0.5){
            double x = Math.random();
            if (this.hasWeapon == true){
                System.out.println("В локации " + this.location.location().getTranslate() + " начинается охота на зверя");
                if(x > 0.5){
                    System.out.println(this.name + " достает оружие и удачно стреляет");
                    if ((animal.getHealth() - ItemType.WEAPON.getPower()) <= 0){
                        throw new InvalidCreatureHealthException(animal.name + " погиб!");
                    }else{
                        animal.setHealth(animal.getHealth() - ItemType.WEAPON.getPower());
                        System.out.println(animal.name + " теперь имеет " + animal.health + " ед. здоровья");
                    }
                }else{
                    System.out.println(this.name + " достает оружие и промахивается");
                    System.out.println(animal.name + " убегает в страхе");
                } 
            }else{
                System.out.println(this.name + " не обнаруживает оружия в инвентаре!");
                System.out.println("Теперь в локации " + this.location.location().getTranslate() + " начинается игра на выживание");
                System.out.println(animal.name + " атакует " + this.name + " и сносит " + animal.getPower() + " ед. урона");
                if ((this.getHealth() - animal.getPower()) <= 0){
                    throw new InvalidCreatureHealthException(this.name + " погиб!");
                }else{
                    this.setHealth(this.getHealth() - animal.getPower());
                    System.out.println(this.name + " теперь имеет " + this.health + " ед. здоровья");
                    System.out.println(this.name + " ищет чем вылечиться после боя");
                    for (Item item : inventory) {
                        if (item.getType() == ItemType.FOOD || item.getType() == ItemType.MEDICINE){
                            if (this.getHealth() + item.getEffect() > 100){
                                throw new InvalidCreatureHealthException("Переизбыток здоровья! "+ item.getName() + " имеет слишком сильный эффект!");
                            } else {
                                this.setHealth(this.getHealth()+item.getEffect());
                                System.out.println("Предмет " + item.getName() + " пополнил " + item.getEffect() + " ед. здоровья");
                
                            }
                        } this.inventory.remove(item);
                    } 
                }
            }
        } else {
            System.out.println(animal.name + " не представляет никакой опасности!");
        }
    }

    @Override
    public void act(){
        System.out.println(this.name + " в поисках деревни");
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }
    public void addToInv(Item item){
        if (item.getType() == ItemType.WEAPON){
            this.hasWeapon = true;
            inventory.add(item);
        }
        if (item.getType() == ItemType.FOOD || item.getType() == ItemType.MEDICINE){
            if (this.getHealth() + item.getEffect() > 100){
                inventory.add(item);
                throw new InvalidCreatureHealthException("Переизбыток здоровья! "+ item.getName() + " отправляется в инвентарь");
            } else {
                this.setHealth(this.getHealth()+item.getEffect());
                System.out.println("Предмет " + item.getName() + " пополнил " + item.getEffect() + " ед. здоровья");
            }
        } item.setLocation(new Location(LocationType.NOTEXIST));
    }
    public void removeFromInv(Item item){
        inventory.remove(item);
        if (item.getType() == ItemType.WEAPON){
            this.hasWeapon = false;
        }
    }
    public void sleep(){
        System.out.println(this.name +" засыпает...");
    }
    public boolean getHasWeapon(){
        return hasWeapon;
    }
}
