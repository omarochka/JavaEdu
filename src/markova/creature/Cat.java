package markova.creature;

public class Cat implements Meowable
{
    String name;

    public Cat(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    public void meow()
    {
        String res = name + ": meow!";
        System.out.println(res);
    }

    public void meow(int n)
    {
        StringBuilder res = new StringBuilder(name + ": ");
        for (int i = 0; i < n; i++)
        {
            res.append("meow-");
        }
        res.deleteCharAt(res.length() - 1).append("!");
        System.out.println(res);
    }
}
