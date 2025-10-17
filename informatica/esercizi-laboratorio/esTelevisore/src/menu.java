import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Televisore tv = new Televisore();

        int scelta;
        do {
            System.out.println("\n--- MENU TELEVISORE ---");
            System.out.println("1. Accendi televisore");
            System.out.println("2. Spegni televisore");
            System.out.println("3. Imposta volume");
            System.out.println("4. Canale successivo");
            System.out.println("5. Canale precedente");
            System.out.println("6. Seleziona canale");
            System.out.println("7. Stato attuale");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    tv.accendi();
                    System.out.println("Televisore acceso");
                    break;
                case 2:
                    tv.spegni();
                    System.out.println("Televisore spento");
                    break;
                case 3:
                    System.out.print("Inserisci volume (0-100): ");
                    int vol = in.nextInt();
                    if (tv.setVolume(vol)) {
                        System.out.println("Volume impostato a " + vol);
                    } else {
                        System.out.println("Operazione non riuscita");
                    }
                    break;
                case 4:
                    if (tv.canaleSuccessivo()) {
                        System.out.println("Canale successivo selezionato");
                    } else {
                        System.out.println("Impossibile cambiare canale (TV spenta?)");
                    }
                    break;
                case 5:
                    if (tv.canalePrecedente()) {
                        System.out.println("Canale precedente selezionato.");
                    } else {
                        System.out.println("Impossibile cambiare canale (TV spenta?)");
                    }
                    break;
                case 6:
                    System.out.print("Inserisci canale (1-999): ");
                    int canale = in.nextInt();
                    if (tv.selezionaCanale(canale)) {
                        System.out.println("Canale impostato a " + canale);
                    } else {
                        System.out.println("Operazione non riuscita");
                    }
                    break;
                case 7:
                    System.out.println(tv);
                    break;
                case 0:
                    System.out.println("Uscita dal programma");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);

    }
}
