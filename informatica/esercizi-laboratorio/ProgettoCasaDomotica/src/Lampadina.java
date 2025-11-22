import graphics.*;

import java.util.Scanner;

public class Lampadina {

    private int potenza;
    private int luminosita;
    private boolean acceso;
    private Ellipse icona;
    private int x, y;
    private Color coloreBase;


    public Lampadina(int potenza, int x, int y) {
        this.potenza = Math.max(0, potenza);
        this.luminosita = 50;
        this.acceso = false;
        this.x = x;
        this.y = y;

        icona = new Ellipse(x, y, 30, 30);
        coloreBase = new Color(128, 128, 128); // grigio iniziale spento
        icona.setColor(coloreBase);

        icona.fill();
        Canvas.getInstance().show(icona);
    }

    public void accendi() {
        acceso = true;
        coloreBase = new Color(255, 255, 0); // GIALLO
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

        switch (scelta) {
            case 1:
                coloreBase = new Color(255, 0, 0);
                break;

            case 2:
                coloreBase = new Color(0, 255, 0);
                break;

            case 3:
                coloreBase = new Color(0, 0, 255);
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