package Event;

public enum LocationType {
    DIRT("Земля"),
    MOUNTAIN("Гора"),
    FOREST("Лес"),
    VALLEY("Долина"),
    VILLAGE("Деревня"),
    HOLLOW("Лощина"),
    GORGE("Ущелье"),
    NOTEXIST("NE");

    private final String translation;

    LocationType(String translation){
        this.translation = translation;
    }

    public String getTranslate(){
        return translation;
    }
}
