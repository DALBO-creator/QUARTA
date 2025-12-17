import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci N: ");
        int N = in.nextInt();

        for (int i = 1; i <= N; i++) {
            lista.add(i);
        }

        System.out.print("Inserisci K: ");
        int K = in.nextInt();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % K == 0) {
                lista.remove(i);
                i--;
            }
        }

        System.out.println("Elementi rimasti:");
        for (int num : lista) {
            System.out.println(num);
        }

        in.close();
    }
}
