package homeworks.basic_tasks.multi_threading.railway_cashbox;

import java.util.Set;

public class Returner implements Runnable {
    private final String name;
    private final Ticket ticket;
    private final Set<Ticket> tickets;
    private final RailwayCashbox cashbox;

    Returner(String name, Ticket ticket, RailwayCashbox cashbox) {
        this.name = name;
        this.cashbox = cashbox;
        this.ticket = ticket;
        tickets = cashbox.getTickets();
    }

    @Override
    public void run() {
        returnTicket();
    }

    private void returnTicket() {
        synchronized (tickets) {
            cashbox.addNewTicket(ticket);
            System.out.println("Билет " + ticket + " сдан, сдаал билет " + name);
            tickets.notifyAll();
        }
    }
}
