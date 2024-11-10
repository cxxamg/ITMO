package pokemons;
import ru.ifmo.se.pokemon.*;
import attacks.*;
public class Azumarill extends Marill {
    public Azumarill(String name, int level){
        super(name,level);
        this.setStats(100,50,80,60,80,50);
        this.setType(Type.WATER,Type.FAIRY);
        this.setMove(new TailWhip(), new Rest(), new Amnesia(), new Facade());
    }
}