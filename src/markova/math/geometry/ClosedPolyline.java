package markova.math.geometry;

public final class ClosedPolyline extends Polyline
{
    public ClosedPolyline(Point2D... point)
    {
        super(point);
    }

    public int getLength(){
        int lenth = super.getLength();
        lenth += new StraightLine(points[points.length - 1], points[0]).getLength();
        return lenth;
    }
}