import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Inserisci il valore di a: ");
        int a = input.nextInt();

        System.out.print("Inserisci il valore di b: ");
        int b = input.nextInt();

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int[] vettore = new int[10];
        for (int i = 0; i < vettore.length; i++) {
            vettore[i] = rand.nextInt(b - a + 1) + a;
        }

        int m = (a + b) / 2;

        System.out.print("Vettore generato: ");
        for (int i = 0; i < vettore.length; i++) {
            System.out.print(vettore[i] + " ");
        }
        System.out.println();

        System.out.print("Valori compresi tra " + a + " e " + m + ": ");
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] >= a && vettore[i] <= m) {
                System.out.print(vettore[i] + " ");
            }
        }
        System.out.println();

        System.out.print("Valori compresi tra " + (m + 1) + " e " + b + ": ");
        for (int i = 0; i < vettore.length; i++) {
            if (vettore[i] >= m + 1 && vettore[i] <= b) {
                System.out.print(vettore[i] + " ");
            }
        }

        input.close();
    }
}
