package pokemons;
import attacks.physicalmoves.*;
import ru.ifmo.se.pokemon.*;
public class Diglett extends Pokemon {
    public Diglett(String name, int level){
        super(name,level);
        this.setStats(10,55,25,35,45,95);
        this.setType(Type.GROUND);
        this.setMove(new AerialAce());
    }
}
