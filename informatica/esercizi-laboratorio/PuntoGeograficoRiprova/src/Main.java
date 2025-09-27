public class Main {
    public static void main(String[] args) {

        //prova creazione di due punti geografici
        Angolo lat1 = new Angolo(41, 54, 0); // 41°54'0'' N
        Angolo long1 = new Angolo(12, 30, 0); // 12°30'0'' E
        PuntoGeografico roma = new PuntoGeografico(lat1, long1);

        Angolo lat2 = new Angolo(45, 32, 19); // 45°32'19'' N
        Angolo long2 = new Angolo(10, 13, 17); // 10°13'17'' E
        PuntoGeografico brescia = new PuntoGeografico(lat2, long2);

        //prova metodo toString
        System.out.println("Punto 1:");
        System.out.println(roma);
        System.out.println();
        System.out.println("Punto 2:");
        System.out.println(brescia);

        System.out.println();

        //prova metodo distanza
        double distanza = roma.distanza(brescia);
        System.out.println("Distanza tra Roma e Brescia: " + distanza + " metri; " + distanza/1000 + " chilometri");

        System.out.println();

        //prova conversione in decimail e radianti
        System.out.println("Conversione angoli in decimali e radianti:");
        System.out.println("Lat Roma decimali: " + lat1.toDecimali() + "°, radianti: " + lat1.toRadianti());
        System.out.println("Lat Brescia decimali: " + lat2.toDecimali() + "°, radianti: " + lat2.toRadianti());
    }
}
