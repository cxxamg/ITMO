package attacks;
import ru.ifmo.se.pokemon.*;
public class Swagger extends StatusMove{
    public Swagger(){
        super(Type.NORMAL, 0, 85);
    }
    protected String describe(){
        return "использует атаку Swagger";
    }
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK,(int)p.getStat(Stat.ATTACK) + 2);
        p.confuse();
    }
}