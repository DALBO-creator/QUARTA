public class ContoCorrente {
    private String name;
    private String surname;
    private String iban;
    private double saldo;
    private Operazione[] operazioni;
    private int numeroOperazioni;

    public ContoCorrente(String n, String c, String i) {
        name = n;
        surname = c;
        iban = i;
        saldo = 0;
        operazioni = new Operazione[100]; // massimo 100 operazioni
        numeroOperazioni = 0;
    }

    public void eseguiOperazione(Operazione o) {
        if (numeroOperazioni >= operazioni.length) {
            System.out.println("Memoria operazioni piena.");
            return;
        }

        if (o.isPrelievo()) {
            if (saldo >= o.getImporto()) {
                saldo -= o.getImporto();
                o.setEseguita(true);
            } else {
                // saldo insufficiente
                o.setEseguita(false);
            }
        } else if (o.isDeposito()) {
            saldo += o.getImporto();
            o.setEseguita(true);
        }

        operazioni[numeroOperazioni] = o;
        numeroOperazioni++;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCodice() {
        return iban;
    }

    public String getNominativo() {
        return name + " " + surname;
    }

    public Operazione getOperazione(int index) {
        if (index >= 0 && index < numeroOperazioni) {
            return operazioni[index];
        }
        return null;
    }

    public int getNumeroOperazioni() {
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita()) {
                n++;
            }
        }
        return n;
    }

    public Operazione[] getPrelievi() {
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isPrelievo() && operazioni[i].isEseguita()) n++;
        }
        Operazione[] res = new Operazione[n];
        int j = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isPrelievo() && operazioni[i].isEseguita()) {
                res[j] = operazioni[i];
                j++;
            }
        }
        return res;
    }

    public Operazione[] getDepositi() {
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isDeposito() && operazioni[i].isEseguita()) n++;
        }
        Operazione[] res = new Operazione[n];
        int j = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isDeposito() && operazioni[i].isEseguita()) {
                res[j] = operazioni[i];
                j++;
            }
        }
        return res;
    }

    public Operazione[] getOperazioniImportanti() {
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita() && operazioni[i].getImporto() > 1000) n++;
        }
        Operazione[] res = new Operazione[n];
        int j = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita() && operazioni[i].getImporto() > 1000) {
                res[j] = operazioni[i];
                j++;
            }
        }
        return res;
    }

    public Operazione[] getOperazioniNonEseguite() {
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (!operazioni[i].isEseguita()) n++;
        }
        Operazione[] res = new Operazione[n];
        int j = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (!operazioni[i].isEseguita()) {
                res[j] = operazioni[i];
                j++;
            }
        }
        return res;
    }

    public Operazione[] getOperazioniMese(int mese) {
        if (mese < 1 || mese > 12) return new Operazione[0];
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita() && operazioni[i].getData().getMonthValue() == mese) n++;
        }
        Operazione[] res = new Operazione[n];
        int j = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita() && operazioni[i].getData().getMonthValue() == mese) {
                res[j] = operazioni[i];
                j++;
            }
        }
        return res;
    }

    public Operazione[] getOperazioniAnno(int anno) {
        int n = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita() && operazioni[i].getData().getYear() == anno) n++;
        }
        Operazione[] res = new Operazione[n];
        int j = 0;
        for (int i = 0; i < numeroOperazioni; i++) {
            if (operazioni[i].isEseguita() && operazioni[i].getData().getYear() == anno) {
                res[j] = operazioni[i];
                j++;
            }
        }
        return res;
    }

    public String toString() {
        return "Conto di " + getNominativo() +
                " (" + iban + ")\nSaldo: " + saldo +
                " €\nOperazioni eseguite: " + getNumeroOperazioni();
    }
}
