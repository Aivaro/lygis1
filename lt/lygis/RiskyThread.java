package lt.lygis;

/**
 * Created by Vavukas on 10/6/2016.
 */
public class RiskyThread extends MyThread {
    public RiskyThread(TicketsSystem tickets) {
        super(tickets);
    }

    @Override
    public void run(){
        System.out.println("Thread " + this + " started");
        for (int i = 0; i<TICKET_NUMBER; i++){
                tickets.buyTicket(i);

            }
        }

    public static void startinam() {
        TicketsSystem tickets = new TicketsSystem();
        tickets.howmany = 0;
        try{
            Thread t1 = new RiskyThread(tickets);
            t1.start();

            Thread t2 = new RiskyThread(tickets);
            t2.start();

            t1.join(); t2.join();

            System.out.println("Total tickets sold: " + tickets.howmany + "/" + MyThread.TICKET_NUMBER);

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
