package markova.creature;

public class Dog implements Barkable
{
    String name;

    public Dog(String name)
    {
        this.name = name;
    }

    public String toString() {
        return "собака: " + name;
    }

    public void bark()
    {
        String res = name + ": bark!";
        System.out.println(res);
    }
}
