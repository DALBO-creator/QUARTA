import java.time.LocalDateTime;

public class Operazione {
    private String causale;
    private double importo;
    private int tipo; // 1 = prelievo, 2 = deposito
    private LocalDateTime data;
    private boolean eseguita;

    public Operazione(String causale, double importo, int tipo) {
        this.causale = causale;
        this.importo = importo;
        if (tipo != 1 && tipo != 2) {
            this.tipo = 2;
        } else {
            this.tipo = tipo;
        }
        this.data = LocalDateTime.now();
        this.eseguita = true;
    }

    public String getCausale() {
        return causale;
    }

    public double getImporto() {
        return importo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public boolean isPrelievo() {
        return tipo == 1;
    }

    public boolean isDeposito() {
        return tipo == 2;
    }

    public boolean isEseguita() {
        return eseguita;
    }

    public void setEseguita(boolean e) {
        eseguita = e;
    }

    private String formattaData(LocalDateTime d) {
        String giorno = "";
        if (d.getDayOfMonth() < 10) giorno = "0" + d.getDayOfMonth();
        else giorno = "" + d.getDayOfMonth();

        String mese = "";
        if (d.getMonthValue() < 10) mese = "0" + d.getMonthValue();
        else mese = "" + d.getMonthValue();

        String ora = "";
        if (d.getHour() < 10) ora = "0" + d.getHour();
        else ora = "" + d.getHour();

        String min = "";
        if (d.getMinute() < 10) min = "0" + d.getMinute();
        else min = "" + d.getMinute();

        return giorno + "/" + mese + "/" + d.getYear() + " alle ore " + ora + ":" + min;
    }

    public String toString() {
        String tipoOp;
        if (isDeposito()) tipoOp = "Deposito";
        else tipoOp = "Prelievo";

        String esito = "";
        if (!eseguita) esito = " (NON ESEGUITA)";

        return tipoOp + " di " + importo + " €, effettuato il " +
                formattaData(data) + esito +
                "\nCausale: " + causale;
    }
}
