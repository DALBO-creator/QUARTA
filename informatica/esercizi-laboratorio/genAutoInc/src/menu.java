import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci il prefisso del codice: ");
        String prefisso = in.nextLine();

        System.out.print("Inserisci il numero di cifre: ");
        int numeroCifre = in.nextInt();

        GeneratoreAutoIncrementale generatore = new GeneratoreAutoIncrementale(prefisso, numeroCifre);

        int scelta;

        do {
            System.out.println("\n    MENU   ");
            System.out.println("1. Genera un nuovo codice");
            System.out.println("2. Visualizza lo stato del generatore");
            System.out.println("3. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = in.nextInt();
            in.nextLine();

            switch (scelta) {
                case 1:
                    String codice = generatore.genera();
                    System.out.println("Codice generato: " + codice);
                    break;
                case 2:
                    System.out.println(generatore.toString());
                    break;
                case 3:
                    System.out.println("Uscita dal programma");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 3);

    }
}
