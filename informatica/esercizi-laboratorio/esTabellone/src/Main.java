public class Main {
    public static void main(String[] args) {
        // Creo il tabellone con le squadre e servizio iniziale a casa
        Tabellone tab = new Tabellone("Brescia", "Reggio Emilia", 1);

        System.out.println("Stato iniziale:");
        System.out.println(tab);

        // Simulo qualche punto per casa
        tab.puntoCasa();
        tab.puntoCasa();
        tab.puntoCasa();
        tab.puntoOspiti();
        tab.puntoOspiti();

        System.out.println("\nDopo alcuni punti:");
        System.out.println(tab);

        // Simulo punteggio fino a fine set (esempio forzato)
        for (int i = 0; i < 22; i++) {
            tab.puntoCasa();
        }

        System.out.println("\nDopo fine primo set:");
        System.out.println(tab);

        // Simulo punti ospiti nel secondo set
        for (int i = 0; i < 25; i++) {
            tab.puntoOspiti();
        }

        System.out.println("\nDopo fine secondo set:");
        System.out.println(tab);

        // Simulo altri punti
        tab.puntoCasa();
        tab.puntoOspiti();

        System.out.println("\nDopo altri punti:");
        System.out.println(tab);
    }
}
