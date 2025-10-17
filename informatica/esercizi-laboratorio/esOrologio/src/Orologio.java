public class Orologio {

    private int ora;
    private int minuti;
    private int svegliaOra;
    private int svegliaMinuti;

    private int stato; // 1: normale, 2: sveglia, 3: orario
    private boolean regolazioneOre;

    public Orologio() {
        ora = 0;
        minuti = 0;
        svegliaOra = 0;
        svegliaMinuti = 0;
        stato = 1;
        regolazioneOre = true;
    }

    public Orologio(int ora, int minuti) {
        if (ora >= 0 && ora < 24 && minuti >= 0 && minuti < 60) {
            this.ora = ora;
            this.minuti = minuti;
        } else {
            this.ora = 0;
            this.minuti = 0;
        }
        svegliaOra = 0;
        svegliaMinuti = 0;
        stato = 1;
        regolazioneOre = true;
    }

    public void impostaOrario() {
        if (stato == 1 || stato == 2) {
            stato = 3;
            regolazioneOre = true;
        } else if (stato == 3) {
            stato = 1;
        }
    }

    public void impostaSveglia() {
        if (stato == 1 || stato == 3) {
            stato = 2;
            regolazioneOre = true;
        } else if (stato == 2) {
            stato = 1;
        }
    }

    public void toggleSveglia() {
        if (svegliaOra == -1 && svegliaMinuti == -1) {
            svegliaOra = 0;
            svegliaMinuti = 0;
        } else {
            svegliaOra = -1;
            svegliaMinuti = -1;
        }
    }

    public void aumenta() {
        if (stato == 3) {
            if (regolazioneOre) {
                ora = ora + 1;
                if (ora == 24) {
                    ora = 0;
                }
            } else {
                minuti = minuti + 1;
                if (minuti == 60) {
                    minuti = 0;
                    ora = ora + 1;
                    if (ora == 24) {
                        ora = 0;
                    }
                }
            }
        } else if (stato == 2) {
            if (regolazioneOre) {
                svegliaOra = svegliaOra + 1;
                if (svegliaOra == 24) {
                    svegliaOra = 0;
                }
            } else {
                svegliaMinuti = svegliaMinuti + 1;
                if (svegliaMinuti == 60) {
                    svegliaMinuti = 0;
                    svegliaOra = svegliaOra + 1;
                    if (svegliaOra == 24) {
                        svegliaOra = 0;
                    }
                }
            }
        }
    }

    public void diminuisci() {
        if (stato == 3) {
            if (regolazioneOre) {
                ora = ora - 1;
                if (ora == -1) {
                    ora = 23;
                }
            } else {
                minuti = minuti - 1;
                if (minuti == -1) {
                    minuti = 59;
                    ora = ora - 1;
                    if (ora == -1) {
                        ora = 23;
                    }
                }
            }
        } else if (stato == 2) {
            if (regolazioneOre) {
                svegliaOra = svegliaOra - 1;
                if (svegliaOra == -1) {
                    svegliaOra = 23;
                }
            } else {
                svegliaMinuti = svegliaMinuti - 1;
                if (svegliaMinuti == -1) {
                    svegliaMinuti = 59;
                    svegliaOra = svegliaOra - 1;
                    if (svegliaOra == -1) {
                        svegliaOra = 23;
                    }
                }
            }
        }
    }

    public void toggleOreMinuti() {
        if (stato == 2 || stato == 3) {
            if (regolazioneOre) {
                regolazioneOre = false;
            } else {
                regolazioneOre = true;
            }
        }
    }

    @Override

    public String toString() {
        String risultato = "";
        String statoStr = "";
        if (stato == 1) {
            statoStr += "1, normale.";
        } else if (stato == 2) {
            if (regolazioneOre) {
                statoStr += "2, regolazione ore.";
            } else {
                statoStr += "2, regolazione minuti.";
            }
        } else if (stato == 3) {
            if (regolazioneOre) {
                statoStr += "3, regolazione ore.";
            } else {
                statoStr += "3, regolazione minuti.";
            }
        }

        String oraStr= "";
        if (ora < 10) {
            oraStr += "0" + ora;
        } else {
            oraStr += "" + ora;
        }

        String minutiStr ="";
        if (minuti < 10) {
            minutiStr += "0" + minuti;
        } else {
            minutiStr += "" + minuti;
        }


        String svegliaStr = "";
        if (svegliaOra == -1 && svegliaMinuti == -1) {
            svegliaStr += "--:--, non attiva";
        } else {
            String svegliaOraStr = "";
            if (svegliaOra < 10) {
                svegliaOraStr += "0" + svegliaOra;
            } else {
                svegliaOraStr += "" + svegliaOra;
            }

            String svegliaMinutiStr = "";
            if (svegliaMinuti < 10) {
                svegliaMinutiStr += "0" + svegliaMinuti;
            } else {
                svegliaMinutiStr += "" + svegliaMinuti;
            }

            svegliaStr += svegliaOraStr + ":" + svegliaMinutiStr + ", attiva";
        }

        risultato += "Orologio in modalità " + statoStr + "\n" +
                "Orario corrente " + oraStr + ":" + minutiStr + "\n" +
                "Sveglia corrente " + svegliaStr;

        return risultato;
    }

}