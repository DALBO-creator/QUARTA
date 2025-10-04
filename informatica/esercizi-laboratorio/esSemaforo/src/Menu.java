import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        semaforo s = new semaforo();
        int scelta;
        do {
            System.out.println("   SEMAFORO   \n" +
                    "1) accendi il semaforo\n" +
                    "2) avanza di luce\n" +
                    "3) scopri lo stato del semaforo\n" +
                    "4) scopri il colore del semaforo\n" +
                    "5) stampa le informazioni sul semaforo\n" +
                    "6) spegni o accedni il semaforo\n" +
                    "0) esci dal programma");

            scelta = in.nextInt();

            switch (scelta){
                case 1: s.accendi();
                break;
                case 2: s.avanza();
                break;
                case 3:
                    System.out.println(s.isAcceso());
                break;
                case 4:
                    System.out.println(s.getColore());
                break;
                case 5:
                    System.out.println(s.toString());
                    break;
                case 6: s.toggle();
                break;
                default:
                    System.out.println("scelta non valida");
                break;
            }
        }
        while(scelta!=0);
        System.out.println("uscita dal programma...");
    }
}
