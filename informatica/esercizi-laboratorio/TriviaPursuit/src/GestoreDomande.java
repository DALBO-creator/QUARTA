import java.io.*;
import java.util.*;

public class GestoreDomande {
    private Map<String, List<Domanda>> domandePerCategoria = new HashMap<>();

    public GestoreDomande(String filePath) {
        caricaDomande(filePath);
    }

    private void caricaDomande(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Formato --> categoria;domanda;risposta1;risposta2;risposta3;risposta4;indiceCorretta(1-4)
                String[] parti = linea.split(";");
                if (parti.length != 7) throw new IOException("Formato file non valido: " + linea);

                String categoria = parti[0];
                String testo = parti[1];
                Risposta[] risposte = new Risposta[4];
                for (int i = 0; i < 4; i++) {
                    boolean corretta = (i == Integer.parseInt(parti[6]) - 1);
                    risposte[i] = new Risposta(parti[i + 2], corretta);
                }

                Domanda d = new Domanda(testo, risposte, categoria);
                domandePerCategoria.putIfAbsent(categoria, new ArrayList<>());
                domandePerCategoria.get(categoria).add(d);
            }
        } catch (Exception e) {
            System.out.println("Errore caricamento domande: " + e.getMessage());
        }
    }

    public List<String> getCategorie() {
        return new ArrayList<>(domandePerCategoria.keySet());
    }

    public Domanda getDomandaCasuale(String categoria) {
        List<Domanda> lista = domandePerCategoria.get(categoria);
        if (lista == null || lista.isEmpty()) return null;
        int index = (int) (Math.random() * lista.size());
        return lista.get(index);
    }
}
