package markova.geography;

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


//    @Override
//    public boolean equals(Object other){return true;}
//    @Override
//    public int hashCode(){return 0;}
}
