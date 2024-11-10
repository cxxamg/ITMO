package attacks;
import ru.ifmo.se.pokemon.*;
public class Facade extends PhysicalMove{
    private boolean isDamageDoubled;
    public Facade(){
        super(Type.NORMAL, 70, 100);
    }
    protected String describe(){
        return "использует атаку Facade";
    }
    protected void applySelfEffects(Pokemon p){
        if (p.getCondition() == Status.PARALYZE || p.getCondition() == Status.BURN || p.getCondition() == Status.POISON){
            this.isDamageDoubled = true;
        }
    }
    protected void applyOppDamage(Pokemon def, double damage) {  
        if (isDamageDoubled) def.setMod(Stat.HP, (int) Math.round(damage * 2));
        else def.setMod(Stat.HP, (int) Math.round(damage));
    }
}