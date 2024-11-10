package attacks;
import ru.ifmo.se.pokemon.*;
public class AerialAce extends PhysicalMove{
    public AerialAce(){
        super(Type.FLYING, 60, Long.MAX_VALUE);
    }
    protected String describe(){
        return "использует атаку Aerial Ace";
    }
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return true;
    }
}
