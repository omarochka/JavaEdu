package geography;

import java.util.ArrayList;

public final class CityTwoWayRoad extends City
{
    public CityTwoWayRoad(String name, Path... initialPaths) {
        super(name, initialPaths);
    }

    public void addPath(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination city cannot be null");
        }
        Path existingPath = super.getExistingPath(destination);
        if (existingPath != null) {
            existingPath.cost = cost;
        }
        else {
            paths.add(new Path(destination, cost));
            destination.paths.add(new Path(this, cost));
        }
    }
}
