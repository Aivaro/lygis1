package lt.lygis;

/**
 * Created by Vavukas on 10/6/2016.
 */
public class Ticket {

    boolean sold;
    int ticketNumber, timeUsed;

    Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}