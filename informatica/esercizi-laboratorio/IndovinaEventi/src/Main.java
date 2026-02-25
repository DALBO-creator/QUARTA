import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> mappaEventi = new HashMap<>();
        List<String> dateRimanenti = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // Caricamento dati da file CSV
        try (BufferedReader br = new BufferedReader(new FileReader("src/eventi.txt"))) {
            String riga;
            //leggo la data , evento dal file e le inserisco nella mappa e nella lista
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(",");
                if (parti.length >= 2) {
                    mappaEventi.put(parti[0].trim(), parti[1].trim());
                    dateRimanenti.add(parti[0].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Errore: file 'eventi.txt' non trovato!");
            return;
        }

        // Fase di memorizzazione
        System.out.println("MEMORIZZATE QUESTE DATE:");
        for (String d : dateRimanenti) {
            System.out.println(d + " -> " + mappaEventi.get(d));
        }

        System.out.println("\nHai 15 secondi...");
        try {
            Thread.sleep(15000); //serve per il ritardo di 15000 millis (15 secondi..)
        } catch (InterruptedException e) {}

        // Pulizia schermo (molto professionale) mando a capo 50 volte e sposto il testo in alto..
        for (int i = 0; i < 50; i++) System.out.println();

        // Variabili per punteggi e turno
        int puntiG1 = 0;
        int puntiG2 = 0;
        int turno = 1;
        Random rand = new Random();

        // fino a quando ci sono delle date rimanenti il gioco continua
        while (!dateRimanenti.isEmpty()) {
            System.out.println("TURNO DEL GIOCATORE " + turno);

            String dataCorrente = dateRimanenti.get(rand.nextInt(dateRimanenti.size()));
            System.out.println("Cosa è successo nel " + dataCorrente + "?");

            // creo le varie opzioni di risposta
            List<String> opzioni = new ArrayList<>();
            opzioni.add(mappaEventi.get(dataCorrente));

            List<String> tuttiEventi = new ArrayList<>(mappaEventi.values());
            Collections.shuffle(tuttiEventi); //serve per mescolare gli elementi di un alista in maniera casuale
            for (String ev : tuttiEventi) {
                if (opzioni.size() < 4 && !opzioni.contains(ev)) {
                    opzioni.add(ev);
                }
            }
            Collections.shuffle(opzioni);

            for (int i = 0; i < opzioni.size(); i++) {
                System.out.println((i + 1) + ") " + opzioni.get(i));
            }

            System.out.print("Risposta: ");
            int scelta = in.nextInt();

            // verifico risposta e gestisco punteggi e turni
            if (opzioni.get(scelta - 1).equals(mappaEventi.get(dataCorrente))) {
                System.out.println("BRAVO! Hai indovinato.\n");
                if (turno == 1) {
                    puntiG1++;
                } else {
                    puntiG2++;
                }
                dateRimanenti.remove(dataCorrente);
            } else {
                System.out.println("ERRORE! Era: " + mappaEventi.get(dataCorrente));
                System.out.println("Passa la mano...\n");

                // uso if-else per il cambio turno
                if (turno == 1) {
                    turno = 2;
                } else {
                    turno = 1;
                }
            }
        }

        // Risultati
        System.out.println("FINE! G1: " + puntiG1 + " - G2: " + puntiG2);
        if (puntiG1 > puntiG2) {
            System.out.println("VINCE IL GIOCATORE 1");
        } else if (puntiG2 > puntiG1) {
            System.out.println("VINCE IL GIOCATORE 2");
        } else {
            System.out.println("PAREGGIO");
        }
    }
}