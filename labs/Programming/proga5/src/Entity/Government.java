package Entity;
public enum Government {
    CORPORATOCRACY,
    KRITARCHY,
    REPUBLIC,
    TIMOCRACY;

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var governmentType : values()) {
            nameList.append(governmentType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
