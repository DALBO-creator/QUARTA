import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci un numero intero positivo N:");
        int N = in.nextInt();

        if (N <= 0) {
            System.out.println("Errore: N deve essere positivo.");
            in.close();
            return;
        }

        System.out.println("Inserisci due numeri float A e B:");
        float A = in.nextFloat();
        float B = in.nextFloat();

        float min, max;

        if (A < B) {
            min = A;
            max = B;
        } else {
            min = B;
            max = A;
        }


        System.out.println("Inserisci " + N + " numeri float:");
        int count = 0;

        for (int i = 0; i < N; i++) {
            float x = in.nextFloat();
            if (x >= min && x <= max) {
                count++;
            }
        }

        System.out.println("Numero di valori compresi tra " + min + " e " + max + ": " + count);

        in.close();
    }
}
