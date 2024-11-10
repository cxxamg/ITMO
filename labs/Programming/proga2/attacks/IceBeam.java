package attacks;
import ru.ifmo.se.pokemon.*;
public class IceBeam extends SpecialMove{
    public IceBeam(){
        super(Type.ICE, 90, 100);
    }
    protected String describe(){
        return "использует атаку IceBeam";
    }
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1){
            Effect.freeze(p);
        }
    }
}
