package markova.math.geometry;

import java.util.Arrays;
import java.util.Objects;

public sealed class Polyline implements LengthMeasurable, Polylinable permits ClosedPolyline
{
    protected Point2D[] points;

    public Polyline(Point2D... point)
    {
        setPoints(point);
    }

    public void setPoints(Point2D... points) {
        this.points = points;
    }

    public void addArrayOfPoints(Point2D[] points){
        int newLen = this.points.length + points.length;
        Point2D[] newArr = new Point2D[newLen];
        System.arraycopy(this.points, 0, newArr, 0, this.points.length);
        System.arraycopy(points, 0, newArr, this.points.length, points.length);
        this.points = newArr;
    }

    public void addPoints(Point2D... points){
        addArrayOfPoints(points);
    }

    public int getLength(){
        int lenth = 0;
        for (int i = 1; i < points.length; i++)
            lenth += new StraightLine(points[i-1], points[i]).getLength();
        return lenth;
    }

    public Point2D[] getPoints() {
        return Arrays.copyOf(points, points.length);
    }

    @Override
    public String toString()
    {
        StringBuilder resultStr = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++)
        {
            resultStr.append(points[i]).append(",");
            if (i + 1 == points.length)
                resultStr.deleteCharAt(resultStr.length() - 1);
        }
        resultStr.append("]");
        return resultStr.toString();
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polyline polyline)) return false;
        Polyline p = (Polyline) o;
        return Arrays.equals(this.getPoints(), p.getPoints());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getPoints());
    }
}
