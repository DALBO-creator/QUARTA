import graphics.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Casa implements Serializable {

    private String nome;
    private List<Stanza> stanze;
    private transient Picture piantina; // le istanze del package graphics non sono serializzabili

    public Casa(String nome, String percorsoImmagine) {
        this.nome = nome;
        this.stanze = new ArrayList<>();
        this.piantina = new Picture(percorsoImmagine);
        this.piantina.draw();
    }

    public void aggiungiStanza(Stanza stanza) {
        stanze.add(stanza);
    }

    public Stanza cercaStanza(String nome) {
        for (Stanza s : stanze) {
            if (s.getNome().equalsIgnoreCase(nome)) return s; //se i due nomi coincidono vuol dire che la stanza è stata trovata

        }
        return null; //utile nel Main per indicare che la stanza non è stata trovata
    }

    public void accendiTutte() {
        for (Stanza s : stanze) s.accendi();
    }

    public void spegniTutte() {
        for (Stanza s : stanze) s.spegni();
    }

    // utiliziamo lo sb anche per la classe Casa
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Casa: " + nome + "\n");
        for (Stanza s : stanze) sb.append(s.toString()).append("\n");
        return sb.toString();
    }
}