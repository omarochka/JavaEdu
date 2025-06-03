package markova.math;

import markova.storeItems.Storage;

import java.util.ArrayList;
import java.util.List;

public class FractionGenerator
{
    private static FractionGenerator instance;
    private List<Fraction> pool = new ArrayList<>(){
        {
            pool.add(new Fraction(1, 2));
            pool.add(new Fraction(1, 3));
            pool.add(new Fraction(5, 4));
        }
    };

    private FractionGenerator() {}

    public static FractionGenerator getInstance() {
        if (instance == null) {
            instance = new FractionGenerator();
        }
        return instance;
    }

    public Fraction generateFraction(int numerator, int denominator) {
        Fraction temp = new Fraction(numerator, denominator);
        for (Fraction fraction: pool){
            if (temp.equals(fraction))
                return fraction;
        }
        return temp;
    }
}
