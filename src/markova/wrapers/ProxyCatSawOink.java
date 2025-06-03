package markova.wrapers;

import markova.creature.Cat;
import markova.creature.Meowable;

public class ProxyCatSawOink implements Meowable
{
    Meowable cat;

    public ProxyCatSawOink(Meowable cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow();
        System.out.println("Oink");
    }
}
