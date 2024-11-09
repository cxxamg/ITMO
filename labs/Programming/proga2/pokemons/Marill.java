package pokemons;
import ru.ifmo.se.pokemon.*;
import attacks.*.*;
public class Marill extends Azurill {
    public Marill(String name, int level){
        super(name,level);
        this.setStats(70,20,50,20,50,40);
        this.setType(Type.WATER,Type.FAIRY);
        this.setMove();
    }
}