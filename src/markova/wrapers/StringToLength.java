package markova.wrapers;

import markova.math.geometry.LengthMeasurable;

public class StringToLength extends Number implements LengthMeasurable {

    int length;

    public StringToLength(String str) {
        length = str.length();
    }

    @Override
    public int intValue() {
        return length;
    }

    @Override
    public long longValue() {
        return length;
    }

    @Override
    public float floatValue() {
        return length;
    }

    @Override
    public double doubleValue() {
        return length;
    }

    @Override
    public int getLength() {
        return length;
    }
}
