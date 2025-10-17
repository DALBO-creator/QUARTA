public class Main {
    public static void main(String[] args) {
        Ascensore asc = new Ascensore(5);

        System.out.println(asc);

        asc.Apri();
        System.out.println("Dopo apertura porte: " + asc);

        asc.Chiudi();
        System.out.println("Dopo chiusura porte: " + asc);

        System.out.println("Sali di un piano: " + asc.Sali());
        System.out.println(asc);

        System.out.println("Scendi di un piano: " + asc.Scendi());
        System.out.println(asc);

        asc.Apri();
        System.out.println("Prova a salire con porte aperte: " + asc.Sali());
        asc.Chiudi();

        System.out.println("Vai al piano 3: " + asc.vaiAlPiano(3));
        System.out.println(asc);

        System.out.println("Vai al piano 6 (inesistente): " + asc.vaiAlPiano(6));
        System.out.println(asc);
    }
}
