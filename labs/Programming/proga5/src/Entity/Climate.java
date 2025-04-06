package Entity;
public enum Climate {
    MONSOON(1),
    HUMIDCONTINENTAL(2),
    STEPPE(3),
    SUBARCTIC(4);

    private final int value;

    Climate(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var climateType : values()) {
            nameList.append(climateType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
