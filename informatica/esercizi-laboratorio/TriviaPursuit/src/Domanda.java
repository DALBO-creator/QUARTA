public class Domanda {
    private String testo;
    private Risposta[] risposte;
    private int rispostaUtente;
    private String categoria;

    public Domanda(String testo, Risposta[] risposte, String categoria) {
        this.testo = testo;
        this.risposte = new Risposta[4];
        for (int i = 0; i < 4; i++) this.risposte[i] = risposte[i];
        this.rispostaUtente = 0;
        this.categoria = categoria;
    }

    public boolean rispondi(int scelta) {
        if (scelta >= 1 && scelta <= 4) {
            rispostaUtente = scelta;
            return risposte[scelta - 1].isCorretta();
        }
        return false;
    }

    public String getRispostaCorretta() {
        for (int i = 0; i < 4; i++) {
            if (risposte[i].isCorretta()) return risposte[i].getTesto();
        }
        return null;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        String s = testo + "\n";
        for (int i = 0; i < 4; i++) {
            s += (i + 1) + ") " + risposte[i].getTesto() + "\n";
        }
        return s;
    }
}
