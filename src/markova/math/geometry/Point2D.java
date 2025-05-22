package markova.math.geometry;

import java.util.Objects;

public sealed class Point2D implements Cloneable permits Point3D
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return this.x == point2D.x && this.y == point2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Point2D clone() throws CloneNotSupportedException {
        return (Point2D) super.clone();
    }
}
