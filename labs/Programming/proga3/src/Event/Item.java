package Event;

import java.util.Objects;

public class Item extends RandomLocation implements Interactable{
    private final String name;
    private final ItemType type;
    private final int effect;
    private Location location;


    public Item(String name, ItemType type){
        this.name = name;
        this.type = type;
        this.effect = type.getPower();
        this.location = new Location(getRandomLocation(LocationType.HOLLOW)); 
    }

    @Override
    public void interact(Human human){
        System.out.println(human.name + " нашел " + this.name);
    }


    public String getName(){
        return name;
    }
    public ItemType getType(){
        return type;
    }
    public int getEffect(){
        return effect;
    }
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return effect == item.effect &&
               Objects.equals(name, item.name) &&
               type == item.type &&
               Objects.equals(location, item.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, effect, location);
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', type=" + type + ", effect=" + effect + ", location=" + location + "}";
    }
}
