import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci N: ");
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int numero = (int)(Math.random() * 1000001);
            lista.add(numero);
        }

        System.out.println("Quadrati perfetti:");

        for (int num : lista) {
            int radice = (int)Math.sqrt(num);
            if (radice * radice == num) {
                System.out.println(num);
            }
        }

        in.close();
    }
}
