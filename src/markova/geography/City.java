package markova.geography;

import java.util.ArrayList;
import java.util.List;

public sealed class City permits CityTwoWayRoad
{
    public String name;
    protected List<Path> paths;

    public City(String name, Path... initialPaths)
    {
        this.name = name;
        this.paths = new ArrayList<>();
        if (initialPaths != null) {
            for (Path path : initialPaths) {
                addPath(path.cityName, path.cost);
            }
        }
    }

    public void addPath(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination city cannot be null");
        }
        Path existingPath = getExistingPath(destination);
        if (existingPath != null) {
            existingPath.cost = cost;
        }
        else {
            paths.add(new Path(destination, cost));
        }
    }

    public void removePath(City destination) {
        if (destination == null) {
            return;
        }
        Path pathToRemove = getExistingPath(destination);
        if (pathToRemove != null) {
            paths.remove(pathToRemove);
        }
    }

    Path getExistingPath(City destination){
        for (Path path : paths) {
            if (path.cityName == destination) // пока ссылки норм)
                return path;
        }
        return null;
    }

    public List<Path> getPaths() {
        List<Path> copy = new ArrayList<Path>();
        for (Path path : paths){
            copy.add(new Path(path.cityName, path.cost));
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder resultStr = new StringBuilder(name);
        resultStr.append(" [");
        if (!paths.isEmpty())
        {
            for (Path path : paths)
            {
                resultStr.append(path).append(",");
            }
            resultStr.deleteCharAt(resultStr.length() - 1);
        }
        resultStr.append("]");
        return resultStr.toString();
    }
}
