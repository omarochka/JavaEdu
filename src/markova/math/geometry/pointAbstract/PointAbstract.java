package markova.math.geometry.pointAbstract;

import java.util.Arrays;

public abstract class PointAbstract
{
    protected int[] coordinates;
    protected String color;
    protected int size;

    public PointAbstract(int... coordinates) {
        this.coordinates = coordinates;
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty())
            throw new IllegalArgumentException("Color must be not null and not empty");
        this.color = color;
    }

    public void setSize(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Size must be positive");
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("Точка в координате ");
        print.append(Arrays.toString(coordinates));
        if(color != null)
            print.append(", ").append(color).append(" цвета");
        if(size != 0)
            print.append(", размером ").append(size);
        return print.toString();
    }
}
