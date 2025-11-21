import graphics.*;

import java.util.Scanner;

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
        }
        else {
            double curva = Math.pow(luminosita / 100.0, 0.5); // implementiamo una curva in modo che il colore venga modificato più dolcemente
            int intensita = (int)(255 * curva);
            Color c = new Color(intensita, intensita, 0); // rosso e verde hanno valori uguali, blu = 0, colore: giallo
            icona.setColor(c);
        }
        icona.fill();
        Canvas.getInstance().repaint();
    }
    public void cambiaColore() {
        if (!acceso) {
            System.out.println("La lampadina è spenta. Accendila prima di cambiare il colore.");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Scegli il colore della lampadina:");
        System.out.println("1) ROSSO");
        System.out.println("2) VERDE");
        System.out.println("3) BLU");
        System.out.print("Scelta: ");

        int scelta = in.nextInt();

        Color nuovoColore;

        switch (scelta) {
            case 1 -> nuovoColore = Color.RED;
            case 2 -> nuovoColore = Color.GREEN;
            case 3 -> nuovoColore = Color.BLUE;
            default -> {
                System.out.println("Scelta non valida. Nessun cambiamento.");
                return;
            }
        }

        icona.setColor(nuovoColore);
        icona.fill();
        Canvas.getInstance().repaint();

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