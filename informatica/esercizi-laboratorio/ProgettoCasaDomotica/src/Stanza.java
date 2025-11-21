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

        lampadine.add(new Lampadina(50, x, y)); // ogni stanza ha una lampadina di default con potenza = 50
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiLampadina() {
        // aggiungiamo una nuova lampadina, ma spostata di 40px verso destra
        //supponiamo che le lampadine aggiunte si trovino sul soffitto in modo tale che possano stare sopra altri elementi della casa
        lampadine.add(new Lampadina(50, x + 40, y));
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