package lessons;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class LearnDates {
    public static void main(String[] args) {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();

        LocalDate localDate = LocalDate.now();

        LocalDate plusDays = localDate.plusDays(3);

        LocalDate gg = LocalDate.now();

        LocalDateTime dd = LocalDateTime.now();

        dd.plusWeeks(6);

        System.out.println(dd.getDayOfYear());

        Calendar cal = Calendar.getInstance();

        cal.set(2020, Calendar.JULY, 12);

        System.out.println(cal.getTime());

    }
}
