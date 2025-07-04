package markova.math.geometry;

import java.util.Objects;

public final class Point3D extends Point2D
{
    public int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder(super.toString());
        temp.deleteCharAt(temp.length() - 1);
        temp.append(";").append(z).append("}");
        return temp.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return this.z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    public Point3D clone() throws CloneNotSupportedException {
        return (Point3D) super.clone();
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        switch (coordinate) {
            case X:
            case Y:
                super.shift(coordinate, value);
                break;
            case Z:
                this.z += value;
                break;
            default:
                throw new IllegalArgumentException("Invalid coordinate for Point3D: " + coordinate);
        }
    }
}
