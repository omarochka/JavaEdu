package geography;

public class Time
{
    final static int MINUTE_IN_HOUR = 60;
    final static int SECOND_IN_MINUTE = 60;
    final static int HOUR_IN_DAY = 24;

    public int sec;

    public Time(int sec)
    {
        this.sec = sec;
    }

    @Override
    public String toString()
    {
        int possibleSec = this.sec % (MINUTE_IN_HOUR * SECOND_IN_MINUTE * HOUR_IN_DAY);

        int hour = possibleSec / (MINUTE_IN_HOUR * SECOND_IN_MINUTE);
        int min = (possibleSec % (MINUTE_IN_HOUR * SECOND_IN_MINUTE)) / MINUTE_IN_HOUR;
        int sec = possibleSec % SECOND_IN_MINUTE;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}
