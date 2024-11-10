package attacks;
import ru.ifmo.se.pokemon.*;
public class DracoMeteor extends SpecialMove{
    public DracoMeteor(){
        super(Type.DRAGON, 130, 90);
    }
    protected String describe(){
        return "использует атаку DracoMeteor";
    }
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_ATTACK,(int)p.getStat(Stat.SPECIAL_ATTACK) - 2);
    }
}