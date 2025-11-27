import graphics.*;

import java.io.Serializable;

public class Lampadina implements Serializable {
    private int luminosita;
    private boolean acceso;
    private transient Ellipse icona; // le istanze del package graphics non sono serializzabili
                                     // quindi dichiariamo questo campo come transient
    private int x, y;
    private transient Color coloreBase; // le istanze del package graphics non sono serializzabili


    private static final Color GRIGIO_INIZIALE = new Color(128, 128, 128);

    public Lampadina(int luminosita, int x, int y) {
        this.luminosita = Math.max(0, Math.min(luminosita, 100));
        this.acceso = false;
        this.x = x;
        this.y = y;

        icona = new Ellipse(x, y, 30, 30);
        coloreBase = GRIGIO_INIZIALE; // colore logico iniziale
        icona.setColor(GRIGIO_INIZIALE);

        icona.fill();
        Canvas.getInstance().show(icona);
    }

    public void accendi() {
        if (!acceso) {
            acceso = true;
            // Se la lampadina è nuova (grigia), viene assegnato il giallo come colore di default
            if (coloreBase.equals(GRIGIO_INIZIALE)) { //grigio assegnato dal costruttore
                coloreBase = new Color(255, 255, 0); // GIALLO
            }
        }
        aggiornaGrafica();
    }


    public void spegni() {
        acceso = false;
        aggiornaGrafica();
    }

    public void aumentaLuminosita() {
        luminosita += 25;
        if (luminosita > 100) luminosita = 100;
        aggiornaGrafica();
    }

    public void diminuisciLuminosita() {
        luminosita -= 25;
        if (luminosita < 0) luminosita = 0;
        aggiornaGrafica();
    }

    private void aggiornaGrafica() {
        if (!acceso) {
            icona.setColor(GRIGIO_INIZIALE); // spento = sempre grigio
        } else {
            double curva = Math.pow(luminosita / 100.0, 0.5);

            int r = (int)(coloreBase.getRed()   * curva);
            int g = (int)(coloreBase.getGreen() * curva);
            int b = (int)(coloreBase.getBlue()  * curva);

            Color c = new Color(r, g, b);
            icona.setColor(c);
        }

        icona.fill();
        Canvas.getInstance().repaint();
    }
    public int getLuminosita() {
        return this.luminosita;
    }



    public void cambiaColore(int scelta) {
        if (!acceso) {
            System.out.println("La lampadina è spenta. Accendila prima di cambiare il colore.");
            return;
        }

        switch (scelta) {
            case 1:
                coloreBase = new Color(255, 0, 0);   // ROSSO
                break;

            case 2:
                coloreBase = new Color(0, 255, 0);   // VERDE
                break;

            case 3:
                coloreBase = new Color(0, 0, 255);   // BLU
                break;

            default:
                System.out.println("Scelta non valida. Nessun cambiamento.");
                return;
        }

        aggiornaGrafica();
        System.out.println("Colore cambiato con successo!");
    }




    public Ellipse getIcona(){
        return this.icona;
    }

    @Override
    public String toString() {
        String stato;
        if (acceso) {
            stato = "Accesa";
        } else {
            stato = "Spenta";
        }

        return "Lampadina [" + stato + ", Luminosità: " + luminosita + "%]";


    }


}