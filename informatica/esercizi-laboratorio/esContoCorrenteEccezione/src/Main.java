import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContoCorrente conto = new ContoCorrente("Davide", "Albo", "123456");
        System.out.println("inserisci importo da depositare (importo > 0)");
        double importo = in.nextDouble();

        try {
            conto.deposita(importo);
            System.out.println("deposito effettuato con successo\n" + "nuovo saldo: " + conto.getSaldo());
        } catch (ImportoNonValidoEccezione e) {
            System.out.println("ERRORE " + e);
        }

        System.out.println("inserisci importo da prelevare");
        importo = in.nextDouble();

        try {
            conto.preleva(importo);
            System.out.println("prelievo effettuato con successo\n" + "nuovo saldo: " + conto.getSaldo());
        } catch (ImportoNonValidoEccezione e) {
            System.out.println("ERRORE " + e);
        }

    }
}