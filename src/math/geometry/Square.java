package math.geometry;

public class Square
{
    private final Point2D upperLeftCorner;
    private int sideLength;

    public Square(Point2D upperLeftCorner, int sideLength){
        this.upperLeftCorner = upperLeftCorner;
        setSideLength(sideLength);
    }

    public Square(int x, int y, int sideLength){
        this(new Point2D(x, y), sideLength);
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Side length must be positive");
        this.sideLength = sideLength;
    }

    public Polyline getPolyline(){
        return new ClosedPolyline(upperLeftCorner, new Point2D(upperLeftCorner.x + sideLength, upperLeftCorner.y),
                new Point2D(upperLeftCorner.x + sideLength, upperLeftCorner.y - sideLength),
                new Point2D(upperLeftCorner.x , upperLeftCorner.y - sideLength), upperLeftCorner);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + upperLeftCorner + " со стороной " + sideLength;
    }
}
