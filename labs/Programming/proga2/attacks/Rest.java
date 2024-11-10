package attacks;
import ru.ifmo.se.pokemon.*;
public class Rest extends StatusMove{
    public Rest(){
        super(Type.PSYCHIC, 0, Long.MAX_VALUE);
    }
    protected String describe(){
        return "использует атаку Rest";
    }
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return true;
    }
    protected void applySelfEffects(Pokemon p){
        Effect.sleep(p);
        p.setMod(Stat.HP, (int)Math.ceil(p.getHP() - p.getStat(Stat.HP)));
        }
    }
