package Entity;
public class Coordinates {
    private final long x;
    private final float y;

    public Coordinates(long x, float y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    public long getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
}
