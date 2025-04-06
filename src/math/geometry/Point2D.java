package math.geometry;

public sealed class Point2D permits Point3D
{
    public int x;
    public int y;

    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("{%d;%d}", this.x, this.y);
    }
}
