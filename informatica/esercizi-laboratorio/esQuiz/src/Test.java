public class Test {
    private Quiz quiz;

    public Test(Quiz quiz) {
        this.quiz = new Quiz(quiz);
    }

    public int getQuanteDomande() {
        return quiz.getNumeroDomande();
    }

    public int getQuanteRisposteDate() {
        int count = 0;
        for (int i = 1; i <= quiz.getNumeroDomande(); i++) {
            Domanda d = quiz.getDomanda(i);
            if (d.completata()) {
                count = count + 1;
            }
        }
        return count;
    }

    public int[] getDomandeNonRisposte() {
        int count = 0;
        for (int i = 1; i <= quiz.getNumeroDomande(); i++) {
            Domanda d = quiz.getDomanda(i);
            if (!d.completata()) {
                count = count + 1;
            }
        }
        int[] indici = new int[count];
        int j = 0;
        for (int i = 1; i <= quiz.getNumeroDomande(); i++) {
            Domanda d = quiz.getDomanda(i);
            if (!d.completata()) {
                indici[j] = i;
                j = j + 1;
            }
        }
        return indici;
    }

    public int getPunteggio() {
        int somma = 0;
        for (int i = 1; i <= quiz.getNumeroDomande(); i++) {
            Domanda d = quiz.getDomanda(i);
            int p = d.getPunteggio();
            if (p > 0) {
                somma = somma + p;
            }
        }
        return somma;
    }

    public int getTotalePunti() {
        return quiz.getTotalePunti();
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public String toString() {
        String s = "Test sul quiz: " + quiz.getTitolo() + "\n";
        s = s + "Domande totali: " + getQuanteDomande() + "\n";
        s = s + "Domande risposte: " + getQuanteRisposteDate() + "\n";
        s = s + "Punteggio ottenuto: " + getPunteggio() + " / " + getTotalePunti() + "\n";
        return s;
    }
}
