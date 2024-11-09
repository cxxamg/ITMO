import ru.ifmo.se.pokemon.*;
import pokemons.Latias;
class Labproga2{
    public static void main(String[] args) {
        Battle b = new Battle();
        Latias p1 = new Latias("test", 1);
        Pokemon p2 = new Pokemon("Хищник", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}