package attacks;
import ru.ifmo.se.pokemon.*;
public class TailWhip extends StatusMove{
    public TailWhip(){
        super(Type.NORMAL, 0, 100);
    }
    protected String describe(){
        return "использует атаку TailWhip";
    }
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.DEFENSE,(int)p.getStat(Stat.DEFENSE) - 1);
    }
}