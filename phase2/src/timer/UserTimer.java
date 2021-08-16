package timer;

import java.util.Date;

public class UserTimer {
    /**
     * Get the current time
     * @return Current time
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * Get the time after a certain amount of minutes
     * @param minute Minute value
     * @return The time after *minute* minutes
     */
    public static Date getTimeAfterMinutes(int minute) {
        Date date = new Date();
        long time = date.getTime();
        time = time + minute * 60000L;
        date.setTime(time);
        return date;
    }
}
