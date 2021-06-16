package homeworks.date_time_calendar_api.calendar_app_by_set;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private LocalDateTime date;
    private String name;
    private String details;

    public Event(LocalDateTime date, String name, String eventDetails) {
        this.date = date;
        this.name = name;
        this.details = eventDetails;
    }

    private Event() {
    }

    public static Event buildWithDateAndName(LocalDateTime date, String name) {
        Event event = new Event();
        event.date = date;
        event.name = name;
        return event;
    }

    public static Event buildWithDate(LocalDateTime date) {
        Event event = new Event();
        event.date = date;
        event.name = "";
        return event;
    }

    public static Event buildWithName(String name) {
        Event event = new Event();
        event.date = LocalDateTime.MIN;
        event.name = name;
        return event;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return date.equals(event.date) && name.equals(event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name);
    }
}
