package Event;

import java.util.Objects;

public abstract class Creature extends RandomLocation{
    protected String name;
    protected int health;
    protected Location location;

    public abstract void interact(Animal animal);
    public abstract void act();

    public void move(){
        LocationType type = getRandomLocation(this.location.location());
        this.location = new Location(type);
        if (Math.random() > 0.5){
            System.out.println(this.name + " идет в " + type.getTranslate()); 
        }else{
            System.out.println(this.name + " держит путь в " + type.getTranslate()); 
        }

    }

    public String getName(){
        return name;
    }
    
    public int getHealth(){
        return health;
    }
    public Location getLocation(){
        return location;
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;  
        Creature other = (Creature) o;
        return health == other.health && Objects.equals(name, other.name) && Objects.equals(location, other.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, location);  
    }

    @Override
    public String toString() {
        return "Creature{name='" + name + "', health=" + health + ", location=" + location + "}";
    }
    
}
