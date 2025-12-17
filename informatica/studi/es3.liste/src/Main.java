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

        System.out.print("Inserisci il numero da cercare: ");
        int x = in.nextInt();

        if (lista.contains(x)) {
            System.out.println("Numero trovato");
        } else {
            System.out.println("Numero non presente");
        }

        in.close();
    }
}
