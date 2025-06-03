package markova.math.geometry.figure;

import markova.math.geometry.Point2D;
import markova.math.geometry.StraightLine;

public class SquareFigure extends RectangleFigure
{
    public SquareFigure(Point2D upperLeftCorner, double a) {
        super(upperLeftCorner, a, a);
    }
}
