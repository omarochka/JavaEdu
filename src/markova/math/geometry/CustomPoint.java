package markova.math.geometry;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomPoint
{
    int[] coordinates;
    List<Object> properties;

    public CustomPoint(int... coordinates)
    {
        if(coordinates.length > 3)
            throw new IllegalArgumentException("Coordinates > 3");
        this.coordinates = coordinates;
    }

    public void setProperties(Object... obj) {
        properties = Arrays.stream(obj).toList();
    }

    @Override
    public String toString() {
        return "CustomPoint{" +
                "coordinates=" + Arrays.toString(coordinates) +
                ", properties=" + properties +
                '}';
    }
}
