package markova.creature;

public class Catdog implements Meowable, Barkable
{
    Meowable cat;
    Barkable dog;

    public Catdog(Meowable cat, Barkable dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public Catdog(String name) {
        this.cat = new Cat(name);
        this.dog = new Dog(name);
    }

    @Override
    public void bark() {
        dog.bark();
    }

    @Override
    public void meow() {
        cat.meow();
    }
}
