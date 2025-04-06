package creature;

import java.util.Random;

public class Parrot extends Bird
{
    public Parrot(String singText){
        if (singText == null || singText.isEmpty()) {
            throw new IllegalArgumentException("Text must be init");
        }
        this.singText = singText;
    }

    @Override
    public void sing() {
        Random random = new Random();
        int maxSing = singText.length();
        int minSing = 1;
        int randomNumber = random.nextInt(maxSing - minSing) + minSing;
        String halfText = singText.substring(0, randomNumber);
        System.out.println(halfText);
    }
}
