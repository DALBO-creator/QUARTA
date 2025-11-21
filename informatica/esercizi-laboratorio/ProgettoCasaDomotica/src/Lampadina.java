import graphics.*;

public class Lampadina {

    private int potenza;
    private int luminosita;
    private boolean acceso;
    private Ellipse icona;
    private int x, y;

    public Lampadina(int potenza, int x, int y) {
        this.potenza = Math.max(0, potenza);
        this.luminosita = 50;
        this.acceso = false;
        this.x = x;
        this.y = y;

        icona = new Ellipse(x, y, 30, 30);
        icona.setColor(Color.GRAY);
        icona.fill();
        Canvas.getInstance().show(icona);
    }

    public void accendi() {
        acceso = true;
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
            icona.setColor(Color.GRAY);
        } else {
            double curva = Math.pow(luminosita / 100.0, 0.5); // implementiamo una curva in modo che il colore venga modificato più dolcemente
            int intensita = (int)(255 * curva);
            Color c = new Color(intensita, intensita, 0); // rosso e verde hanno valori uguali, blu = 0, colore: giallo
            icona.setColor(c);
        }
        icona.fill();
        Canvas.getInstance().repaint();
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