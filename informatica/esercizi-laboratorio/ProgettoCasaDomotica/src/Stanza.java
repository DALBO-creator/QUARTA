import java.util.ArrayList;
import java.util.List;

public class Stanza {

    private String nome;
    private int x, y;
    private List<Lampadina> lampadine;

    public Stanza(String nome, int x, int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.lampadine = new ArrayList<>();

        lampadine.add(new Lampadina(50, x, y)); // una lampadina di default
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiLampadina() {
        // aggiunge una nuova lampadina nella stessa posizione
        lampadine.add(new Lampadina(50, x, y));
    }

    public void rimuoviLampadina(int index) {
        if (index >= 0 && index < lampadine.size()) {
            lampadine.remove(index);
        } else {
            System.out.println("Indice non valido. Nessuna lampadina rimossa.");
        }
    }

    public void accendi() {
        for (Lampadina l : lampadine) l.accendi();
    }

    public void spegni() {
        for (Lampadina l : lampadine) l.spegni();
    }

    public void aumentaLuminosita() {
        for (Lampadina l : lampadine) l.aumentaLuminosita();
    }

    public void diminuisciLuminosita() {
        for (Lampadina l : lampadine) l.diminuisciLuminosita();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stanza: " + nome + "\n");
        for (int i = 0; i < lampadine.size(); i++) {
            sb.append("  Lampadina ").append(i).append(": ")
                    .append(lampadine.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
