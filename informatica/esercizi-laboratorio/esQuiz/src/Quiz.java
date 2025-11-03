public class Quiz {
    private String titolo;
    private Domanda[] domande;
    private int numeroDomande;

    public Quiz(String titolo) {
        this.titolo = titolo;
        this.domande = new Domanda[100];
        this.numeroDomande = 0;
    }

    public Quiz(Quiz altro) {
        this.titolo = altro.titolo;
        this.domande = new Domanda[100];
        this.numeroDomande = altro.numeroDomande;
        for (int i = 0; i < numeroDomande; i++) {
            this.domande[i] = new Domanda(altro.domande[i]);
        }
    }

    public boolean add(Domanda d) {
        if (numeroDomande >= 100) {
            return false;
        }
        domande[numeroDomande] = new Domanda(d);
        numeroDomande = numeroDomande + 1;
        return true;
    }

    public int getNumeroDomande() {
        return numeroDomande;
    }

    public Domanda getDomanda(int indice) {
        if (indice < 1 || indice > numeroDomande) {
            return null;
        } else {
            return domande[indice - 1];
        }
    }

    public int getTotalePunti() {
        int totale = 0;
        for (int i = 0; i < numeroDomande; i++) {
            totale = totale + domande[i].getValore();
        }
        return totale;
    }

    public String getTitolo() {
        return titolo;
    }

    public String toString() {
        String s = "Quiz: " + titolo + "\n";
        s = s + "Numero domande: " + numeroDomande + "\n";
        s = s + "Punteggio totale: " + getTotalePunti() + " punti\n";
        return s;
    }
}
