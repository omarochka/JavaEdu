package creature;

import java.util.Random;

public class Cuckoo extends Bird
{
    public Cuckoo(){
        this.singText = "ку-ку";
    }

    @Override
    public void sing() {
        Random random = new Random();
        int maxSing = 10;
        int minSing = 1;
        int randomNumber = random.nextInt(maxSing - minSing) + minSing;
        for (int i = 0; i < randomNumber; i++)
            System.out.println(this.singText);
    }
}
