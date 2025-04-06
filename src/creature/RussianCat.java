package creature;

public class RussianCat implements Meowable
{
    String name;

    public RussianCat(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    public void meow()
    {
        String res = name + ": мяу!";
        System.out.println(res);
    }
}
