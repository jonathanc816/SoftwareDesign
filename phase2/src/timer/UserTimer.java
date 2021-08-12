package timer;

import java.util.Date;

public class UserTimer {
    public static Date getCurrentTime() {
        return new Date();
    }

    public static Date getTimeAfterMinutes(int minute) {
        Date date = new Date();
        long time = date.getTime();
        time = time + minute * 60000L;
        date.setTime(time);
        return date;
    }

    public static void main(String[] args) {
        Date date = getCurrentTime();
        System.out.println(date.toString());

        Date date2 =getTimeAfterMinutes(30);
        System.out.println(date2.toString());
    }
}
