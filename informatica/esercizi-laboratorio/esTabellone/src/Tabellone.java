public class Tabellone {

    private String squadraCasa;
    private String squadraOspiti;

    private int setVintiCasa;
    private int setVintiOspiti;

    private int puntiCasa;
    private int puntiOspiti;

    private int setCorrente;

    private int squadraAlServizio; // 1 = casa, 2 = ospiti

    public Tabellone(String casa, String ospiti, int inizioServizio) {
        squadraCasa = casa;
        squadraOspiti = ospiti;
        setVintiCasa = 0;
        setVintiOspiti = 0;
        puntiCasa = 0;
        puntiOspiti = 0;
        setCorrente = 1;

        if (inizioServizio == 1 || inizioServizio == 2) {
            squadraAlServizio = inizioServizio;
        } else {
            squadraAlServizio = 1;
        }
    }

    public void puntoCasa() {
        puntiCasa ++;
        squadraAlServizio = 1;
        controllaFineSet();
    }

    public void puntoOspiti() {
        puntiOspiti ++;
        squadraAlServizio = 2;
        controllaFineSet();
    }

    private void controllaFineSet() {
        boolean setFinito = false;
        if ((puntiCasa >= 25 || puntiOspiti >= 25)) {
            int differenza = puntiCasa - puntiOspiti;
            if (differenza >= 2) {
                setFinito = true;
                setVintiCasa ++;
            } else if (differenza <= -2) {
                setFinito = true;
                setVintiOspiti ++;
            }
        }

        if (setFinito) {
            puntiCasa = 0;
            puntiOspiti = 0;
            setCorrente ++;
            if (squadraAlServizio == 1) {
                squadraAlServizio = 2;
            } else {
                squadraAlServizio = 1;
            }
        }
    }
    @Override

    public String toString() {
        String risultato = "";

        risultato += squadraCasa + " - " + squadraOspiti + "\n";
        risultato += puntiCasa + " " + puntiOspiti;

        if (squadraAlServizio == 1) {
            risultato += " *";
        } else {
            risultato += "  ";
        }

        risultato += "\n";
        risultato += "Set " + setCorrente + " " + setVintiCasa + "-" + setVintiOspiti;

        return risultato;
    }

}
