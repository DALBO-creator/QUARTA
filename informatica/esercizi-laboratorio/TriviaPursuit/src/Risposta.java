public class Risposta {
    private String testo;
    private boolean corretta;

    public Risposta(String testo, boolean corretta) {
        this.testo = testo;
        this.corretta = corretta;
    }

    public boolean isCorretta() {
        return corretta;
    }

    public String getTesto() {
        return testo;
    }
}
