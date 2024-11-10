package attacks;
import ru.ifmo.se.pokemon.*;
public class NightSlash extends PhysicalMove{
    public NightSlash(){
        super(Type.DARK, 70, 100);
    }
    protected String describe(){
        return "использует атаку NightSlash";
    }
    protected double calcCriticalHit(Pokemon att, Pokemon def){
        if (Math.random() <= (att.getStat(Stat.SPEED)/170)){
            return 2;
        }else {
            return 1;
        }
    }
}
