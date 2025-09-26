import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero intero positivo N:");
        int N = in.nextInt();

        if (N <= 0) {
            System.out.println("Errore: N deve essere positivo.");
        } else {
            System.out.println("Inserisci " + N + " numeri float:");
            float somma = 0;
            int contatore = 0;

            for (int i = 0; i < N; i++) {
                float x = in.nextFloat();
                if (x > 100) {
                    somma += x;
                    contatore++;
                }
            }

            if (contatore > 0) {
                float media = somma / contatore;
                System.out.printf("Media dei numeri > 100: %.2f\n", media);
            } else {
                System.out.println("Non ci sono numeri maggiori di 100.");
            }
        }

        in.close();
    }
}
