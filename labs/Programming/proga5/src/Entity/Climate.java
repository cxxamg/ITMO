package Entity;
public enum Climate {
    MONSOON,
    HUMIDCONTINENTAL,
    STEPPE,
    SUBARCTIC;

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var climateType : values()) {
            nameList.append(climateType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
