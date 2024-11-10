
import ru.ifmo.se.pokemon.*;
import pokemons.*;
class Labproga2{
    public static void main(String[] args) {
        Battle b = new Battle();
        Latias p1 = new Latias("Фея", 1);
        Diglett p2 = new Diglett("Хищник", 1);
        Dugtrio p3 = new Dugtrio("Охотник", 1);
        Marill p4 = new Marill("Змейка", 1);
        Azurill p5 = new Azurill("Апельсин", 1);
        Azumarill p6 = new Azumarill("Летучий", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}