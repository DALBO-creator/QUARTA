import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestoreDomande gestore = new GestoreDomande("domande.txt");

        System.out.println("Inserisci il tuo nome:");
        Giocatore giocatore = new Giocatore(sc.nextLine());

        boolean continua = true;
        while (continua) {
            int corrette = 0;

            while (true) {
                List<String> categorie = gestore.getCategorie();
                if (categorie.size() < 2) break;
                Collections.shuffle(categorie);
                String cat1 = categorie.get(0);
                String cat2 = categorie.get(1);

                System.out.println("\nScegli una categoria:");
                System.out.println("1) " + cat1);
                System.out.println("2) " + cat2);

                int sceltaCat;
                try {
                    sceltaCat = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input non valido, esci dal gioco.");
                    break;
                }

                String categoriaScelta = sceltaCat == 1 ? cat1 : cat2;


                Domanda d = gestore.getDomandaCasuale(categoriaScelta);
                if (d == null) {
                    System.out.println("Nessuna domanda disponibile per questa categoria.");
                    continue;
                }

                d.toString();
                System.out.println(d);

                System.out.println("Risposta (1-4):");
                int risposta;
                try {
                    risposta = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Input non valido, fine partita.");
                    break;
                }

                if (d.rispondi(risposta)) {
                    System.out.println("Corretto!");
                    corrette++;
                } else {
                    System.out.println("Sbagliato! La risposta corretta era: " + d.getRispostaCorretta());
                    break;
                }

                // Chiede se continuare
                System.out.println("Vuoi continuare? (s/n)");
                String rispostaContinua = sc.nextLine();
                if (!rispostaContinua.equalsIgnoreCase("s")) break;
            }

            System.out.println("Hai risposto correttamente a " + corrette + " domande.");
            System.out.println("Vuoi giocare un'altra partita? (s/n)");
            String nuovaPartita = sc.nextLine();
            if (!nuovaPartita.equalsIgnoreCase("s")) continua = false;
        }

        System.out.println("Grazie per aver giocato!");
        sc.close();
    }
}
