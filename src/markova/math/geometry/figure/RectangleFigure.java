package markova.math.geometry.figure;

public class RectangleFigure extends Figure
{
    protected double a;
    protected double b;

    public RectangleFigure(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double findArea() {
        return a * b;
    }
}
