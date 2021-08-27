package homeworks.basic_tasks.multi_threading.railway_cashbox;

import java.util.Set;

public class Buyer implements Runnable {
    private final String name;
    private final Ticket ticket;
    private final RailwayCashbox cashbox;
    private final Set<Ticket> tickets;
    private boolean isTrue;

    Buyer(String name, Ticket ticket, RailwayCashbox cashbox) {
        this.name = name;
        this.cashbox = cashbox;
        this.ticket = ticket;
        this.tickets = cashbox.getTickets();
        isTrue = true;
    }

    @Override
    public void run() {
        while (isTrue) {
            try {
                buy();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {
        synchronized (tickets) {
            while (tickets.stream()
                    .noneMatch(t -> t.equals(ticket))) {
                System.out.println("Билет " + ticket + " продан");
                tickets.wait();
            }
            cashbox.removeTicket(ticket);
            System.out.println("Билет " + ticket + " куплен, покупатель " + name);
            isTrue = false;
        }
    }
}
