import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            l1.add((int)(Math.random() * 10) + 1);
            l2.add((int)(Math.random() * 10) + 1);
        }

        System.out.println("Lista 1 iniziale: " + l1);
        System.out.println("Lista 2 iniziale: " + l2);

        int cambi = 0;

        while (cambi < 5 && !l1.equals(l2)) {
            System.out.println("Sostituzione numero " + (cambi + 1));
            System.out.print("Quale lista vuoi modificare (1 o 2): ");
            int lista = in.nextInt();

            System.out.print("Posizione da modificare (0-4): ");
            int pos = in.nextInt();

            System.out.print("Nuovo valore (1-10): ");
            int val = in.nextInt();

            if (lista == 1) {
                l1.set(pos, val);
            } else {
                l2.set(pos, val);
            }

            cambi++;

            System.out.println("Lista 1: " + l1);
            System.out.println("Lista 2: " + l2);
        }

        System.out.println("Risultato finale");
        System.out.println("Lista 1: " + l1);
        System.out.println("Lista 2: " + l2);
        System.out.println("Somma lista 1: " + somma(l1));
        System.out.println("Somma lista 2: " + somma(l2));

        in.close();
    }

    public static int somma(ArrayList<Integer> l) {
        int s = 0;
        for (int x : l) s += x;
        return s;
    }
}
