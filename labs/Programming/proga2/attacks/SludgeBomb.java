package attacks;
import ru.ifmo.se.pokemon.*;
public class SludgeBomb extends SpecialMove{
    public SludgeBomb(){
        super(Type.POISON, 90, 100);
    }
    protected String describe(){
        return "использует атаку SludgeBomb";
    }
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.3){
            Effect.poison(p);
        }
    }
}
