import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci il numero di facce del dado: ");
        int n = in.nextInt();

        try {
            Dado d = new Dado(n);
            System.out.println("Dado creato correttamente!");
            System.out.println(d);
            System.out.println("Lancio del dado: " + d.lancia());
        }
        catch (ParametroNonValidoEccezione e) {
            System.out.println("ERRORE: " + e);
        }

        in.close();
    }
}
