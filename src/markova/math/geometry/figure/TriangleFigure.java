package markova.math.geometry.figure;

import markova.math.geometry.Coordinate;
import markova.math.geometry.Point2D;

public class TriangleFigure extends Figure
{
    private Point2D upperLeftCorner;
    private final double a;
    private final double b;
    private final double c;
    private final double p;

    public TriangleFigure(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        p = (a + b + c) / 2;
    }

    @Override
    public double findArea() {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        upperLeftCorner.shift(coordinate, value);
    }
}
