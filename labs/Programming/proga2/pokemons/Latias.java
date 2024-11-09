package pokemons;
import ru.ifmo.se.pokemon.*;
import attacks.*.*;
public class Latias extends Pokemon{
    public Latias(String name, int level){
        super(name,level);
        this.setStats(80,80,90,110,130,110);
        this.setType(Type.DRAGON, Type.PSYCHIC);
        this.setMove(new AerialAce());
    }
}
