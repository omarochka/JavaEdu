package markova.math;

import java.util.Objects;

public final class Fraction extends Number
{
    final int numerator;
    final int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator <= 0)
            throw new IllegalArgumentException("Denominator must be positive");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public Fraction reduce() {
        int commonDivisor = gcd(numerator, denominator);
        return new Fraction(numerator / commonDivisor, denominator / commonDivisor);
    }

    public Fraction addition (Fraction fraction){
        int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    public Fraction addition (int number){
        return addition(new Fraction(number, 1).reduce());
    }

    public Fraction subtraction (Fraction fraction){
        int newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    public Fraction subtraction (int number){
        return subtraction(new Fraction(number, 1).reduce());
    }

    public Fraction multiplication (Fraction fraction){
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    public Fraction multiplication (int number){
        return multiplication(new Fraction(number, 1).reduce());
    }

    public Fraction division (Fraction fraction) {
        if (fraction.denominator == 0)
            return null;
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = fraction.numerator * this.denominator;
        return new Fraction(newNumerator, newDenominator).reduce();
    }

    public Fraction division (int number){
        return division(new Fraction(number, 1).reduce());
    }

    @Override
    public int intValue() {
        return (int)(numerator / denominator);
    }

    @Override
    public long longValue() {
        return (long)intValue();
    }

    @Override
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double)(numerator / denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return this.numerator == fraction.numerator && this.denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
