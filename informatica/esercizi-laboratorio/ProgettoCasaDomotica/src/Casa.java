import graphics.*;
import java.util.ArrayList;
import java.util.List;

public class Casa {

    private String nome;
    private List<Stanza> stanze;
    private Picture piantina;

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

    public void aumentaLuminositaTutte() {
        for (Stanza s : stanze) s.aumentaLuminosita();
    }

    public void diminuisciLuminositaTutte() {
        for (Stanza s : stanze) s.diminuisciLuminosita();
    }

    // utiliziamo lo sb anche per la classe Casa
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Casa: " + nome + "\n");
        for (Stanza s : stanze) sb.append(s.toString()).append("\n");
        return sb.toString();
    }
}