package creature;

public class Sparrow extends Bird
{
    public Sparrow(){
        this.singText = "чирик";
    }

    @Override
    public void sing() {
        System.out.println(this.singText);
    }
}
