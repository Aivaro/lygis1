package lt.lygis;

import java.util.ArrayList;

/**
 * Created by Vavukas on 10/6/2016.
 */
public class TicketsSystem {

    int[] num = new int[MyThread.TICKET_NUMBER];
    int howmany;
    ArrayList<Ticket> tList = new ArrayList<Ticket>();
    public TicketsSystem(){

        for (int j = 0; j < num.length; j++){
            Ticket ticket = new Ticket(j);
            tList.add(ticket);
        }
    }

    public void buyTicket(int i){
        if (!(tList.get(i).isSold())){
            howmany++;
            tList.get(i).setSold(true);
            tList.get(i).timeUsed++;
        }
    }
}
