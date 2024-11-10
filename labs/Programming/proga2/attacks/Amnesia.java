package attacks;
import ru.ifmo.se.pokemon.*;
public class Amnesia extends StatusMove{
    public Amnesia(){
        super(Type.PSYCHIC, 0, Long.MAX_VALUE);
    }
    protected String describe(){
        return "использует атаку Amnesia";
    }
    protected boolean checkAccuracy(Pokemon att, Pokemon def){
        return true;
    }
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_DEFENSE ,(int)p.getStat(Stat.SPECIAL_DEFENSE) + 2);
    }
}