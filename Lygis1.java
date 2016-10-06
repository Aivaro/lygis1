import java.util.ArrayList;

/**
 * Created by Vavukas on 10/6/2016.
 */
public class Lygis1 {

    public static void main(String[] args) {
        MyThread.startinam();
    }
}

class MyThread extends Thread{
    Tickets tickets;
    public MyThread(Tickets tickets){
        this.tickets = tickets;
    }
    public static final int TICKET_NUMBER = 100;

    @Override
    public void run(){
        System.out.println("Thread " + this + " started");
        for (int i = 0; i<TICKET_NUMBER; i++){
//            synchronized (tickets){
                tickets.buyTicket(i);

//            }
        }
    }

    public static void startinam() {
        Tickets tickets = new Tickets();
        tickets.howmany = 0;
        try{
            Thread t1 = new MyThread(tickets);
            t1.start();

            Thread t2 = new MyThread(tickets);
            t2.start();

            t1.join(); t2.join();

            System.out.println("Total tickets sold: " + tickets.howmany );

            System.out.println("Print tickets which were sold twice. " +
                    "Of coures if there tickets like these.");
            int x = 0;
            for (int i=0; i<TICKET_NUMBER; i++){
                if (tickets.tList.get(i).timeUsed > 1 && x==0) {
                    System.out.print(tickets.tList.get(i).ticketNumber);
                    x++;
                }else if (tickets.tList.get(i).timeUsed > 1 && x>0) {
                    System.out.print(", " + tickets.tList.get(i).ticketNumber);
                }
            }
        } catch (InterruptedException e){
            System.out.println("error: " + e);
        }
    }
}

class Tickets{

    int[] num = new int[MyThread.TICKET_NUMBER];
    int howmany;
    ArrayList<Ticket> tList = new ArrayList<Ticket>();
    public Tickets(){

        for (int j = 0; j < num.length; j++){
            Ticket ticket = new Ticket(j);
            tList.add(ticket);
        }
    }

    public void buyTicket(int i){
        if (!(tList.get(i).isSold())){
            tList.get(i).setSold(true);
            howmany++;
            tList.get(i).timeUsed++;
        }
    }
}

class Ticket {

    Ticket(int ticketNumber){
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

    boolean sold;
    int ticketNumber, timeUsed;
}