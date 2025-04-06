import creature.Bird;
import creature.Meowable;
import math.geometry.LengthMeasurable;
import math.geometry.figure.Figure;

public final class PolymorphismUtils
{
    static double additionNumber(Number... numbers){
        double sumRes = 0;
        for (Number value : numbers) {
            sumRes += value.doubleValue();
        }
        return sumRes;
    }

    static void birdMarket(Bird... birds){
        for (Bird value : birds) {
            value.sing();
        }
    }

    static double totalArea(Figure... figures){
        double sumRes = 0;
        for (Figure value : figures) {
            sumRes += value.findArea();
        }
        return sumRes;
    }

    static void meowing(Meowable... meowables){
        for (Meowable value : meowables) {
            value.meow();
        }
    }

    static double measureLength(LengthMeasurable... length){
        double sumRes = 0;
        for (LengthMeasurable value : length) {
            sumRes += value.getLength();
        }
        return sumRes;
    }
}
