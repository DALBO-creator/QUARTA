public class Main {
    public static void main(String[] args) {
        Casa casa = new Casa("Casa Domotica", "assets/piantinaCasa.jpg");

        // Coordinate accurate basate sulla piantina visiva
        casa.aggiungiStanza(new Stanza("Ingresso", 420, 140));      // in alto a sinistra
        casa.aggiungiStanza(new Stanza("Cucina", 300, 140));      // in alto a sinistra
        casa.aggiungiStanza(new Stanza("SalaPranzo", 300, 220));      // sotto Camera 1
        casa.aggiungiStanza(new Stanza("Terrazzo", 220, 380));     // centro sinistra
        casa.aggiungiStanza(new Stanza("Salotto", 275, 380));     // sotto Camera 2
        casa.aggiungiStanza(new Stanza("CameraDaLetto", 500, 406));    // sotto Camera 3
        casa.aggiungiStanza(new Stanza("Bagno1", 480, 220));  // sopra Camera 3
        casa.aggiungiStanza(new Stanza("Bagno2", 555, 245)); // sotto Bagno 1

        casa.cercaStanza("Salotto").accendi();
        casa.cercaStanza("Salotto").aumentaLuminosita();

        System.out.println(casa);
    }
}
