import graphics.*;

public class Stanza {

    private String nome;
    private Lampadina lampadina;

    private Ellipse iconaLampadina;  // cerchio
    private int x;
    private int y;

    public Stanza(String nome, int x, int y) {
        this.nome = nome;
        this.lampadina = new Lampadina(50); // default 50%
        this.x = x;
        this.y = y;

        // Crea l’icona grafica
        iconaLampadina = new Ellipse(x, y, 30, 30);
        iconaLampadina.setColor(Color.GRAY);
        iconaLampadina.fill();

        Canvas.getInstance().show(iconaLampadina);
    }

    public String getNome() {
        return nome;
    }

    public Lampadina getLampadina() {
        return lampadina;
    }

    public void accendi() {
        lampadina.setAcceso(true);
        aggiornaGrafica();
    }

    public void spegni() {
        lampadina.setAcceso(false);
        aggiornaGrafica();
    }

    public void aumentaLuminosita() {
        lampadina.aumentaIlluminazione();
        aggiornaGrafica();
    }

    public void diminuisciLuminosita() {
        lampadina.diminuisciIlluminazione();
        aggiornaGrafica();
    }

    // Aggiorna il colore della lampadina grafica
    private void aggiornaGrafica() {
        if (!lampadina.getAcceso()) {
            iconaLampadina.setColor(Color.GRAY);
            iconaLampadina.fill();
            Canvas.getInstance().repaint();
            return;
        }

        int lum = lampadina.getLuminosita(); // 0–100

        // Più luminosità → più gialla
        int intensita = (int)(255 * (lum / 100.0));
        Color c = new Color(255, 255, intensita);

        iconaLampadina.setColor(c);
        iconaLampadina.fill();

        Canvas.getInstance().repaint();
    }

    @Override
    public String toString() {
        return "Stanza: " + nome + " — " + lampadina.toString();
    }
}
