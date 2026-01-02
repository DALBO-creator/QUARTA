import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MasterMind gioco = new MasterMind();
        System.out.println("Benvenuto a MasterMind! Indovina la sequenza di 4 colori.");

        while (!gioco.terminato()) {
            System.out.println("Inserisci 4 colori separati da spazio (B N V G R A):");
            String[] input = in.nextLine().split(" ");
            if (input.length != 4) {
                System.out.println("Devi inserire esattamente 4 colori.");
                continue;
            }

            try {
                Sequenza tentativo = new Sequenza(
                        Colore.fromLetter(input[0]),
                        Colore.fromLetter(input[1]),
                        Colore.fromLetter(input[2]),
                        Colore.fromLetter(input[3])
                );

                gioco.add(tentativo);
                System.out.println(gioco.toString());

            } catch (IllegalArgumentException e) {
                System.out.println("Colore non valido. Usa solo B N V G R A.");
            }

        }

        if (gioco.vittoria()) {
            System.out.println("Complimenti! Hai indovinato la sequenza in " + gioco.tentativi.size() + " tentativi.");
        } else {
            System.out.println("Hai finito i tentativi. La sequenza era: " + gioco.getSequenzaNascosta());
        }
    }
}

