public class Domanda {
    private String testo;
    private int valore;
    private Risposta[] risposte;  // 4 risposte
    private int rispostaUtente;   // da 1 a 4, 0 se non risposto

    public Domanda(String testo, Risposta[] risposte) {
        this.testo = testo;
        this.valore = 1;
        this.risposte = new Risposta[4];
        for (int i = 0; i < 4; i++) {
            this.risposte[i] = risposte[i];
        }
        this.rispostaUtente = 0;
    }

    public Domanda(Domanda altra) {
        this.testo = altra.testo;
        this.valore = altra.valore;
        this.risposte = new Risposta[4];
        for (int i = 0; i < 4; i++) {
            this.risposte[i] = altra.risposte[i];
        }
        this.rispostaUtente = 0;
    }

    public boolean rispondi(int scelta) {
        if (scelta >= 1 && scelta <= 4) {
            rispostaUtente = scelta;
            if (risposte[scelta - 1].isCorretta()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void setValore(int valore) {
        if (valore > 0) {
            this.valore = valore;
        }
    }

    public int getValore() {
        return valore;
    }

    public int getPunteggio() {
        if (rispostaUtente == 0) {
            return -1;
        }
        if (risposte[rispostaUtente - 1].isCorretta()) {
            return valore;
        } else {
            return 0;
        }
    }

    public boolean completata() {
        if (rispostaUtente == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getRispostaCorretta() {
        for (int i = 0; i < 4; i++) {
            if (risposte[i].isCorretta()) {
                return risposte[i].getTesto();
            }
        }
        return null;
    }

    public String getRispostaData() {
        if (rispostaUtente == 0) {
            return null;
        } else {
            return risposte[rispostaUtente - 1].getTesto();
        }
    }

    public String toString() {
        String s = testo + "\n";
        for (int i = 0; i < 4; i++) {
            s = s + (i + 1) + ") " + risposte[i].getTesto() + "\n";
        }
        return s;
    }
}
