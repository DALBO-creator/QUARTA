import java.io.*;
import java.util.*;

public class Fiore {

    private ArrayList<String> stati;
    private int errori;

    public Fiore(String nomeFile) {
        stati = new ArrayList<>();
        errori = 0;
        caricaStati(nomeFile);
    }

    private void caricaStati(String nomeFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {

            StringBuilder statoCorrente = new StringBuilder();
            String riga;

            while ((riga = br.readLine()) != null) {
                if (riga.equals("---")) {
                    stati.add(statoCorrente.toString());
                    statoCorrente.setLength(0); //sarebbe la pulizia dello string builder
                } else {
                    statoCorrente.append(riga).append("\n");
                }
            }


            if (statoCorrente.length() > 0) {
                stati.add(statoCorrente.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File non trovato: " + nomeFile);
        } catch (IOException e) {
            System.err.println("Errore di lettura del file.");
        }
    }

    public void aumentaErrore() {
        if (errori < stati.size() - 1) {
            errori++;
        }
    }

    public void mostraFiore() {
        if (!stati.isEmpty()) {
            System.out.println(stati.get(errori));
        }
    }

    public boolean Perso() {
        return errori >= stati.size() - 1;
    }
}