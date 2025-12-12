import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci una parola (scrivi stop per finire): ");
            String parola = in.nextLine();

            if (parola.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Inserisci in coda (C) o in posizione (P): ");
            String scelta = in.nextLine().trim().toUpperCase();

            if (scelta.equals("C")) {
                lista.add(parola);
            } else if (scelta.equals("P")) {
                System.out.print("Posizione 0 - " + lista.size() + ": ");
                int pos = in.nextInt();
                in.nextLine();

                if (pos >= 0 && pos <= lista.size()) {
                    lista.add(pos, parola);
                } else {
                    System.out.println("Posizione non valida, inserisco in coda");
                    lista.add(parola);
                }
            } else {
                System.out.println("Scelta non valida, inserisco in coda");
                lista.add(parola);
            }

            System.out.println("Lista: " + lista);
            System.out.println();
        }

        in.close();

        System.out.println("Lista finale: " + lista);
    }
}
