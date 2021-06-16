package homeworks.date_time_calendar_api.testtimepackage;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateCustom {
    public static void main(String[] args) throws InterruptedException {

        //LocalDate
        System.out.println("LocalDate");

        LocalDate currentDate = LocalDate.now();
        System.out.println("method 'now()' - " + currentDate);
        Date date = asDate(currentDate);
        System.out.println("date format is - " + date);

        LocalDateTime zoneIdDate = LocalDateTime.now(ZoneId.of("GMT-12"));
        System.out.println("method 'now(ZoneID)' " + zoneIdDate);

        Clock clock = Clock.system(ZoneId.of("GMT+17"));
        LocalDate clockDate = LocalDate.now(clock);
        System.out.println("method 'now(Clock)' " + clockDate);

        LocalDate fixDate = LocalDate.of(2020, 5, 31);
        LocalDate fixDate2 = LocalDate.of(2020, Month.JUNE, 06);
        System.out.println("method 'of' " + fixDate + "  " + fixDate2);

        LocalDate day165 = LocalDate.ofYearDay(2021, 165);
        System.out.println("method 'ofUnit (dayOfyear)' " + day165);

        LocalDate parsedDate = LocalDate.parse("2011 11 11", DateTimeFormatter.ofPattern("uuuu MM dd"));
        System.out.println("method 'parse' " + parsedDate);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu MMM dd");
        LocalDate parsedDate1 = LocalDate.parse("2021 Dec 11", dtf);
        System.out.println("method 'format' " + parsedDate1.format(dtf));

        System.out.println("method 'plus' " + parsedDate.plus(10, ChronoUnit.DAYS));
        System.out.println("method 'minus' " + parsedDate.minus(10, ChronoUnit.DAYS));

        System.out.println("method 'until with ChroboUnit' " + currentDate.until(parsedDate, ChronoUnit.MONTHS));
        System.out.println("method 'until with ChroboUnit' " + parsedDate.until(currentDate, ChronoUnit.MONTHS));
        System.out.println("method 'until' " + currentDate.until(parsedDate));
        System.out.println("method 'until' " + parsedDate.until(currentDate));

        System.out.println("method 'is After' " + currentDate.isAfter(parsedDate));
        System.out.println("method 'is Before' " + currentDate.isBefore(parsedDate));

        //LocalDateTime
        System.out.println("LocalDateTime");
        LocalDateTime custom = LocalDateTime.now();
        OffsetDateTime offset = custom.atOffset(ZoneOffset.ofHours(6));
        System.out.println("method 'atOffset' " + offset);

        System.out.println("method 'atZone' " + custom.atZone(ZoneId.of("GMT+7")));

        LocalDateTime loc = LocalDateTime.from(offset);
        System.out.println("method 'from' " + loc);

        System.out.println("method 'truncatedTo' " + loc.truncatedTo(ChronoUnit.MINUTES));//"Minutes"

        LocalDateTime local = LocalDateTime.parse("2021-02-02T14:15:16");
        LocalDateTime local2 = LocalDateTime.parse("2022-04-01T12:15:16");

        Period period = Period.between(local.toLocalDate(), local2.toLocalDate());
        System.out.println("Period  " + period);
        System.out.println("method 'plus (Period)' " + local.plus(period));

        System.out.println("method 'range' " + local.range(ChronoField.DAY_OF_MONTH));

        System.out.println("Calendar");
        TimeZone tz = TimeZone.getTimeZone(ZoneId.of("GMT+12"));
        Calendar cal = Calendar.getInstance(tz);
        System.out.println("method 'get instance(TimeZone)' and getTimeZone() " + cal.getTimeZone().getDisplayName());
        System.out.println(cal.getTime());

        cal.add(Calendar.YEAR, 5);
        System.out.println("method 'add' " + cal.getTime());

        cal.set(Calendar.MONTH, 5);
        System.out.println("method 'set' " + cal.getTime());

        Date date1 = Date.from(cal.toInstant());
        System.out.println(date1);



    }


    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDateAltWay(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


}
