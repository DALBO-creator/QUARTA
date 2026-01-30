package com.albo.bandierefx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gestore {
    private List<Domanda> domande = new ArrayList<>();
    private int indiceAttuale = 0;
    private int punteggio = 0;

    public static class Domanda {
        String url, o1, o2, o3, o4, corretta;
        public Domanda(String url, String o1, String o2, String o3, String o4, String corretta) {
            this.url = url; this.o1 = o1; this.o2 = o2; this.o3 = o3; this.o4 = o4; this.corretta = corretta;
        }
    }

    public void caricaDati(String nomeFile) {
        // Cerca il file nel classpath (nella stessa cartella della classe)
        try (InputStream is = getClass().getResourceAsStream(nomeFile);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            if (is == null) {
                System.err.println("Errore: File " + nomeFile + " non trovato!");
                return;
            }

            String riga;
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(",");
                if (parti.length == 6) {
                    domande.add(new Domanda(parti[0].trim(), parti[1].trim(), parti[2].trim(),
                            parti[3].trim(), parti[4].trim(), parti[5].trim()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Domanda getDomandaCorrente() {
        return (indiceAttuale < domande.size()) ? domande.get(indiceAttuale) : null;
    }

    public void controllaRisposta(String risposta) {
        if (indiceAttuale < domande.size()) {
            if (domande.get(indiceAttuale).corretta.equalsIgnoreCase(risposta)) {
                punteggio++;
            }
            indiceAttuale++;
        }
    }

    public boolean isFinito() { return indiceAttuale >= domande.size(); }
    public int getPunteggio() { return punteggio; }
    public int getTotale() { return domande.size(); }
}