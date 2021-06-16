package homeworks.date_time_calendar_api.calendar_app_by_set;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.Set;

public class CalendarService {
    private static final String FORMAT_FOR_INPUT_DATE = "uuuu MM dd";
    private static final String FORMAT_FOR_INPUT_DATETIME = "uuuu MM dd HH:mm";
    private static final String FORMAT_FOR_OUTPUT_DATETIME = "uuuu MMM dd (HH:mm)";
    private static final String FORMAT_FOR_OUTPUT_DATE = "uuuu MMM dd";
    private Set<Event> eventList;

    CalendarService() {
        eventList = new HashSet<>();
    }

    public static LocalDateTime parseToDateTimeCustomFormat(String date, String formatter) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(formatter)).atTime(0, 1);
    }

    public static LocalDateTime parseToDateSystemFormat(String stringDate) {
        return parseToDateTimeCustomFormat(stringDate, FORMAT_FOR_INPUT_DATE);
    }

    public static LocalDateTime parseToDateTimeSystemFormat(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(FORMAT_FOR_INPUT_DATETIME));
    }

    public static ZoneId getTimeZone(String country, String city) {
        return ZoneId.of(country.concat("/").concat(city));
    }

    public static ZoneId getTimeZone(String timeZoneGMT) {
        return ZoneId.of(timeZoneGMT);
    }

    public void addEventToList(Event event) {
        eventList.add(event);
    }

    public void showAllEvents() {
        showEvents(eventList);
    }

    public void showEvents(Set<Event> eventList) {
        System.out.println("Events:");
        int index = 1;
        for (Event event : eventList) {
            String text = "Event#" + index++;
            System.out.println("---- " + text + " ----\n" + text + " Date --> " +
                    event.getDate().format(DateTimeFormatter.ofPattern(FORMAT_FOR_OUTPUT_DATETIME)) + "\n" +
                    text + " Name -->" + event.getName() + "\n" +
                    text + " Details -->" + event.getDetails() + "\n" +
                    "------------------------------------------------");
        }
    }

    public void deleteEvent(Event event) {                                                                                    //
        LocalDateTime date = event.getDate();
        String name = event.getName();
        if (!isEventInList(event)) {
            System.out.println("No such events in DB");
            return;
        }
        int counter = 0;
        for (Event e : eventList) {
            if (e.getDate().getDayOfYear() == date.getDayOfYear() && e.getName().equals(name)) {
                eventList.remove(e);
                counter++;
            }
        }

        System.out.println("Event/s (" + counter + " pcs) with name " + name + " and date " +
                date.format(DateTimeFormatter.ofPattern(FORMAT_FOR_OUTPUT_DATE)) + " successfully deleted");
    }

    public void deleteAllEventsByDate(LocalDateTime date) {
        if (!isEventInListByOneCond(Event.buildWithDate(date))) {                                                           //
            System.out.println("No such events in DB");
            return;
        }
        int i = 0;
        for (Event event : eventList) {
            if (event.getDate().getDayOfYear() == date.getDayOfYear()) {
                eventList.remove(event);
                i++;
            }
        }
        System.out.println("Event/s (" + i + " pcs) with Date: " +
                date.format(DateTimeFormatter.ofPattern(FORMAT_FOR_OUTPUT_DATE)) + ", was successfully deleted");
    }

    public void deleteAllEventsByName(String name) {
        if (!isEventInListByOneCond(Event.buildWithName(name))) {                                                         //
            System.out.println("No such events in DB");
            return;
        }
        int i = 0;
        for (Event event : eventList) {
            if (event.getName().equals(name)) {
                eventList.remove(event);
                i++;
            }
        }
        System.out.println("Events (" + i + ") with Name: " + name + ", was successfully deleted");
    }

    public boolean isEventInList(Event event) {                                                                   //
        for (Event e : eventList) {
            if (e.getDate().getDayOfYear() == event.getDate().getDayOfYear() &&
                    e.getName().equals(event.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isEventInListByOneCond(Event event) {                                                                   //
        for (Event e : eventList) {
            if (e.getDate().getDayOfYear() == event.getDate().getDayOfYear() ||
                    e.getName().equals(event.getName())) {
                return true;
            }
        }
        return false;
    }

    public void editEvent(Event existEvent, Event newEvent) {                                                               //!!!//
        addEventToList(newEvent);
        deleteEvent(existEvent);
    }

    public Set<Event> collectEventsByDate(LocalDateTime date) {
        Set<Event> events = new HashSet<>();
        for (Event event : eventList) {
            if (event.getDate().getDayOfYear() == date.getDayOfYear()) {
                events.add(event);
            }
        }
        return events;
    }

    public LocalDateTime showCurrentTimeByTZ(ZoneId timeZone) {
        try {
            return LocalDateTime.now(timeZone);
        } catch (DateTimeException e) {
            e.getLocalizedMessage();
        }
        return LocalDateTime.of(1970, 12, 12, 12, 12);
    }

    public LocalDateTime showCurDateLocal() {
        return LocalDateTime.now();
    }

    public void showEventsByCurDate(LocalDateTime date) {
        Set<Event> events = collectEventsByDate(date);
        if (!events.isEmpty()) {
            showEvents(events);
        } else {
            System.out.println("No any events on current Date");
        }
    }

    public void printOutDateCustom(LocalDateTime localDT, String format) {
        System.out.println(localDT.format(DateTimeFormatter.ofPattern(format)));
    }

    public void printOutDateSystem(LocalDateTime localDT) {
        printOutDateCustom(localDT, FORMAT_FOR_OUTPUT_DATETIME);
    }

    public void printOutTime(LocalDateTime localDT) {
        System.out.println("Time is --> " + localDT.getHour() + ":" + localDT.getMinute());
    }

    public void printOutDate(LocalDateTime localDT) {
        System.out.print("Date is --> ");
        printOutDateCustom(localDT, FORMAT_FOR_OUTPUT_DATE);
    }

    public void printOutDayOfWeek(LocalDateTime localDT) {
        System.out.println("Day of Week is --> " + localDT.getDayOfWeek());
    }

    public void printOutNumberDayInYear(LocalDateTime localDT) {
        System.out.println("Number Day in year is --> " + localDT.getDayOfYear());
    }

    public void printOutQtyDaysToNY(LocalDateTime localDT) {
        LocalDateTime temp = localDT.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(localDT.until(temp, ChronoUnit.DAYS));
    }

    public LocalDateTime goToDateAfterXWeeks(int weeks) {
        return showCurDateLocal().plusWeeks(weeks);
    }

    public LocalDateTime goToDateAfterXMonths(int months) {
        return showCurDateLocal().plusMonths(months);
    }

    public LocalDateTime goToDateAfterXYears(int years) {
        return showCurDateLocal().plusDays(years);
    }


}
