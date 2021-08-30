package homeworks.basic_tasks.multi_threading.railway_cashbox;

import java.util.HashSet;
import java.util.Set;

public class RailwayCashbox {

    private Set<Ticket> tickets;

    RailwayCashbox() {
        tickets = new HashSet<>();
    }

    public void addNewTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }
}
