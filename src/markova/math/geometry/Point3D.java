package markova.math.geometry;

public final class Point3D extends Point2D
{
    public int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
