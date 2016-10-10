package lt.lygis;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Užduotį atliko Aivaras Šilalė 2 grupės PS magistrantūros studentas
 *
 *
 *
 * Programa pademonstruoja kaip veikia sinchronizuotos bei nesinchronizuotos gijos.
 * Implementuojamas toks minimalistinis programos scenarijus:
 *
 * Yra parduodami lėktuvo bilietai.
 * Lėktuvas turi 100 lasivų vietų.
 *
 * Iškylanti problema: Programai veikiant nesinchronizuotai, atsiranda galimybė, kad programa tikrindama ar bilietas jau parduotas gali suklysti ir parduoti tą patį bilietą.
 * Kodėl taip nutinka? Programa veikia taip, jog tikrinamas bilietas, ar jis nėra parduotas. Jeigu jis nėra parduotas, tuomet
 * pažymime jį, kaip parduotą ir daugiau nebeleidžiame jo pirkti. Bėda ta, kad mums patikrinus ar bilietas nėra parduotas ir vykdant kitus veiksmus,
 * paraleliai dirbanti gija gali taip pat patikrinti tą patį bilietą ir pirmajai gijai nespėjus bilieto pažymėti kaip parduoto antroji gija taip pat jį parduos.
 *
 * Sprendimas: Naudoti Synchronized metodą, gija neturės galimybės manipuliuoti bendru objektu, jeigu jis jau bus naudojamas.
 *
 *
 */

public class Main {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Jeigu norite patikrinti atvejį, kuomet IŠGAUSIME kritinę klaidą įveskite 1");
        System.out.println("Jeigu norite patikrinti atvejį, kuomet IŠVENGSIME kritinės klaidos įveskite 2");
        int choice = sn.nextInt();
        switch (choice) {
            case 1:  choice = 1;
                // Pasirinkti galime gija, kurioje  nėra saugoma kritinė sekcija
                RiskyThread.startinam();
                break;
                // Gija, kurioje yra saugoma kritinė sekcija
            case 2:  choice = 1;
                MyThread.startinam();
                break;
        }
    }
}
