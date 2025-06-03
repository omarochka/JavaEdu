package markova.math.geometry;

public class PointFactory
{
    public static Point2D createPoint(int x, int y) {
        return new Point2D(x, y);
    }

    public static Point3D createPoint(int x, int y, int z) {
        return new Point3D(x, y, z);
    }
}
