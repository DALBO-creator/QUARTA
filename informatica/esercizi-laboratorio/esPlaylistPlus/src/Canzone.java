import java.time.Duration;

public class Canzone {
    String titolo;
    Duration durata;
    String artista;

    public Canzone(String titolo, Duration durata, String artista) {
        this.titolo = titolo;
        this.durata = durata;
        this.artista = artista;
    }

    public String getTitolo() {
        return titolo;
    }
    public Duration getDurata() {
        return this.durata;
    }
    public String getArtista() {
        return artista;
    }
}
