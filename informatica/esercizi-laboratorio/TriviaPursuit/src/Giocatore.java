public class Giocatore {
    private String nome;
    private int punteggio;

    public Giocatore(String nome) {
        this.nome = nome;
        this.punteggio = 0;
    }

    public void incrementaPunteggio() {
        punteggio++;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getNome() {
        return nome;
    }
}
