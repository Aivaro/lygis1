package lt.lygis;

import java.util.ArrayList;

/**
 * Created by Vavukas on 10/6/2016.
 */
public class MyThread extends Thread{
    TicketsSystem tickets;
    public MyThread(TicketsSystem tickets){
        this.tickets = tickets;
    }
    public static final int TICKET_NUMBER = 100;

    @Override
    public void run(){
        System.out.println("Thread " + this + " started");
        for (int i = 0; i<TICKET_NUMBER; i++){
            synchronized (tickets){
            // Kritinė sekcija, kurios metu galimi programos netikslumai. Ją išsprendžiame su synchronized.
                tickets.buyTicket(i);

            }
        }
    }

    public static void startinam() {
        TicketsSystem tickets = new TicketsSystem();
        tickets.howmany = 0;
        try{
            Thread t1 = new MyThread(tickets);
            t1.start();

            Thread t2 = new MyThread(tickets);
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

