package markova.math.geometry;

import java.util.Objects;

public class StraightLine<T extends Point2D> implements LengthMeasurable, Cloneable
{
    private final T originCoordinate;
    private final T finalCoordinate;

    public StraightLine(T originCoordinate, T finalCoordinate)
    {
        this.originCoordinate = originCoordinate;
        this.finalCoordinate = finalCoordinate;
    }

    public T getOriginCoordinate() {
        return originCoordinate;
    }

    public T getFinalCoordinate() {
        return finalCoordinate;
    }

    @Override
    public String toString() {
        return String.format("Линия от %s до %s",
                originCoordinate, finalCoordinate);
    }

    public static int pow(int x)
    {
        return x * x;
    }

    public int getLength()
    {
        double len = Math.sqrt(StraightLine.pow(finalCoordinate.x - originCoordinate.x) + StraightLine.pow(finalCoordinate.y - originCoordinate.y));
        return (int)len;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StraightLine<?> that = (StraightLine<?>) o;
        boolean condition1 = this.originCoordinate.equals(that.finalCoordinate)
                && this.finalCoordinate.equals(that.originCoordinate);
        boolean condition2 = this.originCoordinate.equals(that.originCoordinate)
                && this.finalCoordinate.equals(that.finalCoordinate);
        return condition1 || condition2;
    }

    @Override
    public int hashCode() {
        int hashCode1 = Objects.hash(originCoordinate, finalCoordinate);
        int hashCode2 = Objects.hash(finalCoordinate, originCoordinate);
        return Objects.hash(hashCode1 + hashCode2);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
