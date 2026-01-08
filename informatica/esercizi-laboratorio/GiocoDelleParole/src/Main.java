import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String parola = "marmellata";
        String parolaScoperta = "";
        ArrayList<Character> lettereUsate = new ArrayList<>();

        //all'inizio le parole sono tutti trattini
        for (int i = 0; i < parola.length(); i++) {
            parolaScoperta += "_";
        }

        Fiore fiore = new Fiore("src/stati_fiore.txt");

        while (true) {
            // ciclo infinito per comodità (e per provare)

            System.out.println("Parola: " + parolaScoperta);
            System.out.print("Inserisci la lettera: ");
            char lettera = in.next().toLowerCase().charAt(0);

            if (lettereUsate.contains(lettera)) {
                System.out.println("Lettera già inserita!");
                continue;
            }

            lettereUsate.add(lettera);

            String nuovaParola = "";
            boolean trovata = false;

            for (int i = 0; i < parola.length(); i++) {
                if (parola.charAt(i) == lettera) {
                    nuovaParola += lettera;
                    trovata = true;
                } else {
                    nuovaParola += parolaScoperta.charAt(i);
                }
            }

            parolaScoperta = nuovaParola;

            if (!trovata) {
                System.out.println("Lettera sbagliata!");
                fiore.aumentaErrore();
            }

            fiore.mostraFiore();

            if (!parolaScoperta.contains("_")) {
                System.out.println("Hai indovinato la parola: " + parola);
                break;
            }

            if (fiore.Perso()) {
                System.out.println("Hai perso! La parola era: " + parola);
                break;
            }
        }
    }
}
