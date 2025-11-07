import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Semaforo s = new Semaforo();
        int scelta = -1;

        do {
            System.out.println("\n===== MENU SEMAFORO =====");
            System.out.println("1) Accendi il semaforo");
            System.out.println("2) Avanza di luce");
            System.out.println("3) Mostra stato (acceso/spento)");
            System.out.println("4) Mostra colore attuale");
            System.out.println("5) Stampa informazioni sul semaforo");
            System.out.println("6) Cambia stato (accendi/spegni)");
            System.out.println("0) Esci dal programma");
            System.out.print("Scelta: ");

            if (!in.hasNextInt()) {
                System.out.println("Inserisci un numero valido.");
                in.next(); // scarta input non valido
                continue;
            }

            scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    s.accendi();
                    System.out.println("Semaforo acceso.");
                    break;

                case 2:
                    s.avanza();
                    System.out.println("Avanzato al colore: " + s.getColore());
                    break;

                case 3:
                    if (s.isAcceso())
                        System.out.println("Il semaforo è acceso.");
                    else
                        System.out.println("Il semaforo è spento.");
                    break;

                case 4:
                    System.out.println("Colore attuale: " + s.getColore());
                    break;

                case 5:
                    System.out.println(s.toString());
                    break;

                case 6:
                    s.toggle();
                    if (s.isAcceso()) {
                        System.out.println("Stato cambiato: acceso");
                    } else {
                        System.out.println("Stato cambiato: spento");
                    }
                    break;

                case 0:
                    System.out.println("Uscita dal programma...");
                    break;

                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }

        } while (scelta != 0);

        in.close();
    }
}
