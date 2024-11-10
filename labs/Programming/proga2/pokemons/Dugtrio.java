package pokemons;
import ru.ifmo.se.pokemon.*;
import attacks.*;
public class Dugtrio extends Diglett {
    public Dugtrio(String name, int level){
        super(name,level);
        this.setStats(35,100,50,50,70,120);
        this.setType(Type.GROUND);
        this.setMove(new Facade(), new SludgeBomb(), new AerialAce(), new NightSlash());
    }
}
