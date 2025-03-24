package Entity;
public class Coordinates {
    private long x;
    private float y;

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
