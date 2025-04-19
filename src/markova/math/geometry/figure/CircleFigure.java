package markova.math.geometry.figure;

public class CircleFigure extends Figure
{
    private final double radius;

    public CircleFigure(double radius){
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }
}
