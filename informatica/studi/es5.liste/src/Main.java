import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci N: ");
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int numero = (int)(Math.random() * 101);
            lista.add(numero);
        }

        System.out.println("Lista originale:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }

        ArrayList<Integer> nuova = new ArrayList<>(lista);

        for (int i = 1; i < lista.size() - 1; i++) {
            int prec = lista.get(i - 1);
            int succ = lista.get(i + 1);
            int att = lista.get(i);

            if (att == prec + succ) {
                nuova.set(i, prec * 2);
            }
        }

        System.out.println("Lista modificata:");
        for (int i = 0; i < nuova.size(); i++) {
            System.out.println(i + ": " + nuova.get(i));
        }

        in.close();
    }
}
