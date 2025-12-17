import graphics.Canvas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stanza implements Serializable {

    private String nome;
    private int x, y, maxLampadine;
    private List<Lampadina> lampadine;

    public Stanza(String nome, int x, int y, int maxLampadine) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.maxLampadine = maxLampadine;
        this.lampadine = new ArrayList<>();

        lampadine.add(new Lampadina(50, x, y)); // ogni stanza ha una lampadina di default con  = 50
    }

    public String getNome() {
        return nome;
    }

    public List<Lampadina> getLampadine() {
        return lampadine;
    }

    public boolean aggiungiLampadina() {
        //aggiungiamo una nuova lampadina, ma spostata di 40px verso destra
        //supponiamo che le lampadine aggiunte si trovino sul soffitto in modo tale che possano stare sopra altri elementi della casa
        if (lampadine.size() >= maxLampadine) {
            System.out.println("Numero massimo di lampadine raggiunto (" + maxLampadine + ").");
            return false;
        }

        if (lampadine.isEmpty()) {
            //la prima lampadina è in posizione fissa

            lampadine.add(new Lampadina(50, x, y));
        }
        else {
            //si potrebbe fare la stessa cosa per il colore (una volta aggiunta una lampadina, questa prende il colore
            // della prima lampadina della stanza), ma abbiamo preferito che una volta aggiunta, alla prima accensione questa risulti gialla
            // a prescindere dal colore della prima lampadina
            Lampadina lampadinaDefault = lampadine.getFirst(); // la prima lampadina della stanza
            int lum = lampadinaDefault.getLuminosita();    // getter della luminosità attuale (della prima lamapdina)
            int newX = lampadine.getLast().getIcona().getX() + 40; //la lampadina nuova è traslata di 40px
                                                                   // verso destra rispetto all'ultima lampadina (sul soffitto)

            lampadine.add(new Lampadina(lum, newX, y));
        }
        return true;
    }

    public void rimuoviLampadina(int i) {
        if (i >= 0 && i < lampadine.size()) {
            Lampadina l = lampadine.get(i);

            //aggiungiamo il metodo hide alla classe Canvas, che rappresenta il contrario del metodo show
            Canvas.getInstance().hide(l.getIcona());

            //Rimuoviamo la lampadina dalla lista
            lampadine.remove(i);

        } else {
            System.out.println("Indice non valido. Nessuna lampadina rimossa.");
        }
    }

    public void cambiaColore() {
        Scanner in = new Scanner(System.in);
        System.out.println("Scegli il colore per tutte le lampadine della stanza:");
        System.out.println("1) ROSSO");
        System.out.println("2) VERDE");
        System.out.println("3) BLU");
        System.out.println("4) GIALLO");
        System.out.print("Scelta: ");
        int scelta = in.nextInt();

        for (Lampadina l : lampadine) {
            l.cambiaColore(scelta);
        }
        System.out.println("Colore cambiato con successo per tutte le lampadine!");
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
    //scegliamo di sperimentare l'utilizzo dello string builder
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