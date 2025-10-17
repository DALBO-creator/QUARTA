public class Main {
    public static void main(String[] args) {
        // Creo un orologio con orario di default (00:00)
        Orologio orologio = new Orologio();
        System.out.println("Orologio creato con costruttore vuoto:");
        System.out.println(orologio);
        System.out.println();

        // Creo un orologio con orario 13:45
        Orologio orologio2 = new Orologio(13, 45);
        System.out.println("Orologio creato con orario 13:45:");
        System.out.println(orologio2);
        System.out.println();

        // Provo a impostare orario in modalità normale -> passa a stato 3 (orario)
        orologio2.impostaOrario();
        System.out.println("Dopo impostaOrario() (da normale a orario):");
        System.out.println(orologio2);
        System.out.println();

        // Aumento ore (sono in regolazione ore)
        orologio2.aumenta();
        System.out.println("Dopo aumenta() ore:");
        System.out.println(orologio2);
        System.out.println();

        // Passo a regolazione minuti
        orologio2.toggleOreMinuti();
        System.out.println("Dopo toggleOreMinuti() (regolazione minuti):");
        System.out.println(orologio2);
        System.out.println();

        // Aumento minuti
        orologio2.aumenta();
        System.out.println("Dopo aumenta() minuti:");
        System.out.println(orologio2);
        System.out.println();

        // Diminuisco minuti
        orologio2.diminuisci();
        System.out.println("Dopo diminuisci() minuti:");
        System.out.println(orologio2);
        System.out.println();

        // Torno a modalità normale (stato 1)
        orologio2.impostaOrario();
        System.out.println("Dopo impostaOrario() (da orario a normale):");
        System.out.println(orologio2);
        System.out.println();

        // Passo a impostazione sveglia
        orologio2.impostaSveglia();
        System.out.println("Dopo impostaSveglia() (da normale a sveglia):");
        System.out.println(orologio2);
        System.out.println();

        // Aumento ore sveglia
        orologio2.aumenta();
        System.out.println("Dopo aumenta() ore sveglia:");
        System.out.println(orologio2);
        System.out.println();

        // Toggle regolazione (ore -> minuti)
        orologio2.toggleOreMinuti();
        System.out.println("Dopo toggleOreMinuti() (regolazione minuti sveglia):");
        System.out.println(orologio2);
        System.out.println();

        // Aumento minuti sveglia
        orologio2.aumenta();
        System.out.println("Dopo aumenta() minuti sveglia:");
        System.out.println(orologio2);
        System.out.println();

        // Disattivo sveglia
        orologio2.toggleSveglia();
        System.out.println("Dopo toggleSveglia() (sveglia disattivata):");
        System.out.println(orologio2);
        System.out.println();

        // Riattivo sveglia
        orologio2.toggleSveglia();
        System.out.println("Dopo toggleSveglia() (sveglia riattivata):");
        System.out.println(orologio2);
        System.out.println();

        // Torno a modalità normale
        orologio2.impostaSveglia();
        System.out.println("Dopo impostaSveglia() (da sveglia a normale):");
        System.out.println(orologio2);
        System.out.println();

        // Provo a premere + in modalità normale (non deve cambiare niente)
        orologio2.aumenta();
        System.out.println("Dopo aumenta() in modalità normale (nessun effetto):");
        System.out.println(orologio2);
        System.out.println();

        // Provo a premere - in modalità normale (nessun effetto)
        orologio2.diminuisci();
        System.out.println("Dopo diminuisci() in modalità normale (nessun effetto):");
        System.out.println(orologio2);
        System.out.println();
    }
}
