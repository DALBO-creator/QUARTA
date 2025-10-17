public class TabelloneTennis {

    private String giocatore1;
    private String giocatore2;

    private int setVinti1;
    private int setVinti2;

    private int gameVinti1;
    private int gameVinti2;

    // 0, 15, 30, 40
    private int puntiGame1;
    private int puntiGame2;

    private int puntiTieBreak1;
    private int puntiTieBreak2;

    private boolean tieBreak;
    private boolean partitaFinita;

    private boolean servizioPerGiocatore1;

    private int tipoPartita; // 3 o 5 set

    public TabelloneTennis(String giocatore1, String giocatore2, int primoServizio, int tipoPartita) {
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;

        this.setVinti1 = 0;
        this.setVinti2 = 0;

        this.gameVinti1 = 0;
        this.gameVinti2 = 0;

        this.puntiGame1 = 0;
        this.puntiGame2 = 0;

        this.puntiTieBreak1 = 0;
        this.puntiTieBreak2 = 0;

        this.tieBreak = false;
        this.partitaFinita = false;

        if (primoServizio == 1) {
            this.servizioPerGiocatore1 = true;
        } else if (primoServizio == 2) {
            this.servizioPerGiocatore1 = false;
        } else {
            this.servizioPerGiocatore1 = true;
        }

        if (tipoPartita == 3 || tipoPartita == 5) {
            this.tipoPartita = tipoPartita;
        } else {
            this.tipoPartita = 3;
        }
    }

    private int incrementaPunto(int puntiGiocatore, int puntiAvversario) {
        if (puntiGiocatore == 0) {
            return 15;
        } else if (puntiGiocatore == 15) {
            return 30;
        } else if (puntiGiocatore == 30) {
            return 40;
        } else if (puntiGiocatore == 40) {
            if (puntiAvversario < 40) {
                return 40;
            } else {
                return 50;
            }
        } else if (puntiGiocatore == 50) {
            return 50;
        }
        return puntiGiocatore; // fallback
    }

    public boolean aggiungiPunto(int giocatore) {
        if (partitaFinita) {
            return false;
        }

        if (giocatore != 1 && giocatore != 2) {
            return false;
        }

        if (tieBreak) {
            if (giocatore == 1) {
                puntiTieBreak1++;
            } else {
                puntiTieBreak2++;
            }
            // Funzionamento del tieBreak...

        } else {
            if (giocatore == 1) {
                puntiGame1 = incrementaPunto(puntiGame1, puntiGame2);
            } else {
                puntiGame2 = incrementaPunto(puntiGame2, puntiGame1);
            }

            // aggiorna i game, i set e la partita...
        }

        // serve chi ha vinto il punto
        servizioPerGiocatore1 = (giocatore == 1);

        return true;
    }

    //vittoria() e toString()..
}
