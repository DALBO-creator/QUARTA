import java.time.LocalDateTime;

public class Azione {
    private String descrizione;
    private LocalDateTime dataOra;
    private int livelloAttenzione;

    // Costruttore
    public Azione(String descrizione, int livelloAttenzione) {
        this.descrizione = descrizione;
        this.livelloAttenzione = livelloAttenzione;
        this.dataOra = LocalDateTime.now(); // istante corrente
    }

    // Getter
    public String getDescrizione() {
        return descrizione;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public int getLivelloAttenzione() {
        return livelloAttenzione;
    }

    // Descrizione testuale del livello di attenzione
    private String descrizioneLivello() {
        switch (livelloAttenzione) {
            case 1: return "nessun problema";
            case 2: return "annotazione";
            case 3: return "evento moderato";
            case 4: return "evento grave";
            case 5: return "evento critico";
            default: return "livello sconosciuto";
        }
    }

    @Override
    public String toString() {
        return "Descrizione: " + descrizione + "\n" +
                dataOra + "\n" +
                descrizioneLivello();
    }
}
