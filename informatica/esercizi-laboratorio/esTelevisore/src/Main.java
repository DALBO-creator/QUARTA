public class Main {
    public static void main(String[] args) {
        Televisore tv = new Televisore();

        System.out.println(tv); // spento

        tv.accendi();
        System.out.println(tv);

        System.out.println("Set volume a 50: " + tv.setVolume(50));
        System.out.println("Set volume a 150 (non funziona): " + tv.setVolume(150));
        System.out.println("Canale successivo: " + tv.canaleSuccessivo());
        System.out.println("Canale precedente: " + tv.canalePrecedente());
        System.out.println("Seleziona canale 100: " + tv.selezionaCanale(100));
        System.out.println("Seleziona canale 1000 (non funziona): " + tv.selezionaCanale(1000));

        tv.spegni();
        System.out.println(tv);


        System.out.println("Provo a cambiare canale da spento: " + tv.canaleSuccessivo());
        System.out.println("Provo a cambiare volume da spento: " + tv.setVolume(30));
    }
}


