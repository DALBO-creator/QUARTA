import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float somma = 0;

        System.out.println("Scegli un numero intero positivo (N):");
        int N = in.nextInt();

        if (N <= 0) {
            System.out.println("Errore: devi inserire un numero intero positivo.");
        } else {
            System.out.println("Inserisci " + N + " numeri float:");
            for (int i = 0; i < N; i++) {
                float F = in.nextFloat();
                somma += F;
            }
            float media = somma / N;
            System.out.printf("La media è: " +  media);
        }

        in.close();
    }
}
