package markova.geography;

import java.util.Objects;

public class Path
{
    City cityName;
    int cost;

    public Path(City cityName, int cost)
    {
        this.cityName = cityName;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", cityName.name, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return this.cost == path.cost && this.cityName.name.equals(path.cityName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName.name, cost);
    }
}
