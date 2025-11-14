public class Lampadina {
    private int potenza;
    private int luminosita;
    private String nome;
    private boolean acceso;

    public Lampadina(int potenza){
        if (potenza < 0){
            potenza = Math.abs(potenza);
        }
        this.potenza = potenza;
        this.nome = "";
        this.luminosita = 50;
        this.acceso = false;
    }

    public int getPotenza(){
        return this.potenza;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public boolean getAcceso(){
        return this.acceso;
    }

    public int getLuminosita() {
        return this.luminosita;
    }

    public void setLuminosita(int luminosita) {
        if (luminosita < 0) luminosita = 0;
        if (luminosita > 100) luminosita = 100;
        this.luminosita = luminosita;
    }

    public void aumentaIlluminazione() {
        if (luminosita < 100) {
            luminosita += luminosita * 10 / 100;
            if (luminosita > 100) luminosita = 100;
        }
    }

    public void diminuisciIlluminazione() {
        if (luminosita > 0) {
            luminosita -= luminosita * 10 / 100;
            if (luminosita < 0) luminosita = 0;
        }
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() +
                " | Potenza: " + this.getPotenza() +
                "W | Stato: " + (this.getAcceso() ? "Accesa" : "Spenta") +
                " | Illuminazione: " + this.getLuminosita() + "%";
    }
}
