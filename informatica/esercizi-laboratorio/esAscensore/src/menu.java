import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci il numero di piani dell'ascensore: ");
        int n = in.nextInt();
        Ascensore asc = new Ascensore(n);

        int scelta;
        do {
            System.out.println("\n--- MENU ASCENSORE ---");
            System.out.println("1. Visualizza stato");
            System.out.println("2. Apri porte");
            System.out.println("3. Chiudi porte");
            System.out.println("4. Sali");
            System.out.println("5. Scendi");
            System.out.println("6. Vai a un piano specifico");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println(asc);
                    break;
                case 2:
                    asc.Apri();
                    System.out.println("Porte aperte");
                    break;
                case 3:
                    asc.Chiudi();
                    System.out.println("Porte chiuse");
                    break;
                case 4:
                    if (asc.Sali()) {
                        System.out.println("Salito di un piano");
                    } else {
                        System.out.println("Impossibile salire");
                    }
                    break;
                case 5:
                    if (asc.Scendi()) {
                        System.out.println("Sceso di un piano");
                    } else {
                        System.out.println("Impossibile scendere");
                    }
                    break;
                case 6:
                    System.out.print("Inserisci il piano desiderato (0-" + asc.getPiani() + "): ");
                    int p = in.nextInt();
                    if (asc.vaiAlPiano(p)) {
                        if (p == 0) {
                            System.out.println("Ascensore spostato al piano terra");
                        } else {
                            System.out.println("Ascensore spostato al piano " + p);
                        }
                    } else {
                        System.out.println("Impossibile raggiungere il piano");
                    }

                    break;
                case 0:
                    System.out.println("Uscita dal programma..");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);

    }
}
