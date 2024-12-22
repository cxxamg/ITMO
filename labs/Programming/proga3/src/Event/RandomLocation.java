package Event;

public abstract class RandomLocation {

    public static LocationType getRandomLocation(LocationType ltype) {
        LocationType[] values = LocationType.values(); // Переносим массив вне цикла
        LocationType randomLocation;
        do{
            int randomIndex = (int) (Math.random() * values.length);
            randomLocation = values[randomIndex];
        } while (randomLocation == ltype || randomLocation == LocationType.NOTEXIST);
        return randomLocation;
    }
}
