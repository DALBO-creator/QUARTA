import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeri[] = new int[10];
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci il numero di valori interi che vuoi inserire (max 10):");
        int DIM = in.nextInt();

        if (DIM > 10) {
            System.out.println("Hai inserito un numero troppo grande, userò 10 come massimo.");
            DIM = 10;
        }

        int conta_pari = 0;
        int conta_dispari = 0;

        System.out.println("Inserisci " + DIM + " numeri interi:");
        for (int i = 0; i < DIM; i++) {
            numeri[i] = in.nextInt();
            if (numeri[i] % 2 == 0)
                conta_pari++;
            else
                conta_dispari++;
        }

        int[] pari = new int[conta_pari];
        int[] dispari = new int[conta_dispari];

        int ip = 0;
        int id = 0;

        for (int i = 0; i < DIM; i++) {
            if (numeri[i] % 2 == 0) {
                pari[ip] = numeri[i];
                ip++;
            } else {
                dispari[id] = numeri[i];
                id++;
            }

            System.out.println("Elementi pari (" + conta_pari + "): ");
            for (int j = 0; j < pari.length; j++) {
                System.out.print(pari[j] + " ");
                System.out.println();
            }

            System.out.println("Elementi dispari (" + conta_dispari + "): ");
            for (int j = 0; j < dispari.length; j++) {
                System.out.print(dispari[j] + " ");
                System.out.println();
            }

            in.close();
        }
    }
}
