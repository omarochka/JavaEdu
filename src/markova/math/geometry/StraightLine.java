package markova.math.geometry;

import java.util.Objects;

public class StraightLine implements LengthMeasurable
{
    private Point2D originCoordinate;
    private Point2D finalCoordinate;

    public StraightLine(Point2D originCoordinate, Point2D finalCoordinate)
    {
        this(originCoordinate.x, originCoordinate.y, finalCoordinate.x, finalCoordinate.y);
    }

    public StraightLine(int x1, int y1, int x2, int y2)
    {
        setOriginCoordinate(new Point2D(x1, y1));
        setFinalCoordinate(new Point2D(x2, y2));
    }

    public void setOriginCoordinate(Point2D originCoordinate) {
        this.originCoordinate = originCoordinate;
    }

    public void setFinalCoordinate(Point2D finalCoordinate) {
        this.finalCoordinate = finalCoordinate;
    }

    public Point2D getOriginCoordinate() {
        return new Point2D(originCoordinate.x, originCoordinate.y);
    }

    public Point2D getFinalCoordinate() {
        return new Point2D(finalCoordinate.x, finalCoordinate.y);
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
        StraightLine that = (StraightLine) o;
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
}
