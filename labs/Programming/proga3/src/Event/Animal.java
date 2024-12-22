package Event;

public class Animal extends Creature implements Interactable{
    private final double aggressive;
    private final int power;


    public Animal(String name, int health, Location location, int power){
        this.name = name;
        if (health <= 0 || health > 100){
            throw new InvalidCreatureHealthException("Здоровье должно быть от 1 до 100");
        }
        this.health = health;
        this.aggressive = Math.random();
        this.location = location;
        this.power = power;
    }

    @Override
    public void act(){
        if (aggressive > 0.5) {
            System.out.println(this.name + "\s" + "ищет воду");
        }else{
            System.out.println(this.name + "\s" + "рычит");
        }
    }

    @Override
    public void interact(Animal animal){
        System.out.println("В локации " + this.location.location().getTranslate() + " начинается битва зверей!");
        if (animal.aggressive > this.aggressive){
            System.out.println(animal.name + " атакует " + this.name + " и сносит " + animal.power + " ед. урона");
            if ((this.getHealth() - animal.power) <= 0){
                this.alive = false;
                throw new InvalidCreatureHealthException(this.name + " погиб!");
            }else{
                this.setHealth(this.getHealth() - animal.power);
                System.out.println(this.name + " теперь имеет " + this.health + " ед. здоровья");
            }
        } else {
            System.out.println(this.name + " атакует " + animal.name + " и сносит " + this.power + " ед. урона");
            if ((animal.getHealth() - this.power) <= 0){
                animal.alive = false;
                throw new InvalidCreatureHealthException(animal.name + " погиб!");
            }else{
                animal.setHealth(animal.getHealth() - this.power);
                System.out.println(animal.name + " теперь имеет " + animal.health + " ед. здоровья");
            }
        }
    }

    @Override
    public void interact(Human human){
        System.out.println(this.name + " нервно смотрит на " + human.name);
    }



    public double getAggressive(){
        return aggressive;
    }
    public int getPower(){
        return power;
    }


}
