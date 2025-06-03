package markova.geography;

import java.util.ArrayList;
import java.util.List;

public class Temperature
{
    // Можно сделать через enum и Temperature.values()
    private static final List<Temperature> enumTemps = new ArrayList<>(){
        {
            enumTemps.add(new Temperature("Холодно", -50, 10));
            enumTemps.add(new Temperature("Нормально", 10, 25));
            enumTemps.add(new Temperature("Жарко", 25, 60));
        }
    };

    private final String name;
    private final int minTemp;
    private final int maxTemp;

    Temperature(String name, int minTemp, int maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public static Temperature getTemperature(int temp) {
        for(Temperature temperature: enumTemps){
            if (temp >= temperature.minTemp && temp < temperature.maxTemp)
                return temperature;
        }
        throw new IllegalArgumentException("Температура вне допустимого диапазона");
    }

    @Override
    public String toString() {
        return name;
    }
}
