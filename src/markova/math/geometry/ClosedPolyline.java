package markova.math.geometry;

import java.util.Arrays;

public final class ClosedPolyline extends Polyline
{
    public ClosedPolyline(Point2D... point)
    {
        super(point);
    }

    public void setPoints(Point2D... points) {
        Point2D[] tempPoints = Arrays.copyOf(points, points.length + 1);
        tempPoints[tempPoints.length - 1] = points[0];
        this.points = tempPoints;
    }

    public int getLength(){
        int lenth = super.getLength();
        lenth += new StraightLine(points[points.length - 1], points[0]).getLength();
        return lenth;
    }

}