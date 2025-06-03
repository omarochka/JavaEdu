package markova.math.geometry.figure;

import markova.math.geometry.Coordinate;
import markova.math.geometry.Point2D;

public class RectangleFigure extends Figure
{
    protected Point2D upperLeftCorner;
    protected final double a;
    protected final double b;

    public RectangleFigure(Point2D upperLeftCorner, double a, double b){
        this.upperLeftCorner = upperLeftCorner;
        this.a = a;
        this.b = b;
    }

    @Override
    public double findArea() {
        return a * b;
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        upperLeftCorner.shift(coordinate, value);
    }

    @Override
    public String toString() {
        return "RectangleFigure{" +
                "upperLeftCorner=" + upperLeftCorner +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
