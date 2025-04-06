package geography;

public class House
{
    private final int numberOfFloors;

    public House(int numberOfFloors)
    {
        if (numberOfFloors <= 0)
            throw new IllegalArgumentException("Number of floors must be positive");
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString()
    {
        String floorResult = "";
        if (this.numberOfFloors % 10 == 1 && this.numberOfFloors % 100 != 11)
            floorResult += " этажом";
        else floorResult += " этажами";
        return "дом с "+ numberOfFloors + floorResult;
    }
}
