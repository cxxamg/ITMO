package Event;

public enum ItemType {
    WEAPON(50),
    FOOD(30),
    MEDICINE(50);


    private final int power;

    ItemType(int power){
        this.power = power;
    }
    public int getPower(){
        return power;
    }
}