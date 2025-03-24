package Entity;
public enum StandardOfLiving {
    VERY_LOW,
    ULTRA_LOW,
    NIGHTMARE;

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var standardOfLivingType : values()) {
            nameList.append(standardOfLivingType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
