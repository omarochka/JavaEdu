package markova.wrapers;

import markova.creature.Cat;
import markova.creature.Meowable;

public class ProxyCatCountMeow implements Meowable {

    Meowable cat;
    int countOfMeow;

    public ProxyCatCountMeow(Meowable cat) {
        this.cat = cat;
    }

    public String getCountOfMeow() {
        return "кот мяукал " + countOfMeow + " раз";
    }

    @Override
    public void meow() {
        cat.meow();
        this.countOfMeow++;
    }
}
