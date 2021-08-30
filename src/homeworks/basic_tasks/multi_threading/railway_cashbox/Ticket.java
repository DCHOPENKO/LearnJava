package homeworks.basic_tasks.multi_threading.railway_cashbox;

import java.util.Objects;

public class Ticket {
    private final String departCityName;
    private final String arrivalCityName;

    Ticket(String departCityName, String arrivalCityName) {
        this.departCityName = departCityName;
        this.arrivalCityName = arrivalCityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return departCityName.equals(ticket.departCityName) && arrivalCityName.equals(ticket.arrivalCityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departCityName, arrivalCityName);
    }

    @Override
    public String toString() {
        return departCityName + " - " + arrivalCityName;
    }
}
