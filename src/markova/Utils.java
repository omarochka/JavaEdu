package markova;

import markova.creature.Bird;
import markova.creature.Meowable;
import markova.math.geometry.LengthMeasurable;
import markova.math.geometry.Polylinable;
import markova.math.geometry.Polyline;
import markova.math.geometry.figure.Figure;

public final class Utils
{
    public static double additionNumber(Number... numbers){
        double sumRes = 0;
        for (Number value : numbers) {
            sumRes += value.doubleValue();
        }
        return sumRes;
    }

    public static void birdMarket(Bird... birds){
        for (Bird value : birds) {
            value.sing();
        }
    }

    public static double totalArea(Figure... figures){
        double sumRes = 0;
        for (Figure value : figures) {
            sumRes += value.findArea();
        }
        return sumRes;
    }

    public static void meowing(Meowable... meowables){
        for (Meowable value : meowables) {
            value.meow();
        }
    }

    public static double measureLength(LengthMeasurable... length){
        double sumRes = 0;
        for (LengthMeasurable value : length) {
            sumRes += value.getLength();
        }
        return sumRes;
    }

    public static Polyline polylineUnion(Polylinable... polyline){
        Polyline tempPolyline = new Polyline();
        for (Polylinable value : polyline) {
            tempPolyline.addPoints(value.getPolyline().getPoints());
        }
        return tempPolyline;
    }

    public static int pow(String x, String y){
        int tempX = Integer.parseInt(x);
        int tempY = Integer.parseInt(y);
        return (int) Math.pow(tempX, tempY);
    }
}
