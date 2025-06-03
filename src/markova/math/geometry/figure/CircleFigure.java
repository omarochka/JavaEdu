package markova.math.geometry.figure;

import markova.math.geometry.Coordinate;
import markova.math.geometry.Point2D;
import markova.math.geometry.StraightLine;

public class CircleFigure extends Figure
{
    private Point2D center;
    private final double radius;

    public CircleFigure(Point2D center, double radius)
    {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        center.shift(coordinate, value);
    }
}
