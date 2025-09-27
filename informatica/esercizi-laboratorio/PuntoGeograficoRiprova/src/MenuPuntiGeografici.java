import java.util.Scanner;

public class MenuPuntiGeografici {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci il primo punto geografico:");
        System.out.print("Latitudine (gradi primi secondi, separati da spazi, gradi negativi se il punto si trova a sud dell'equatore): ");
        double g1 = in.nextDouble();
        double p1 = in.nextDouble();
        double s1 = in.nextDouble();
        Angolo lat1 = new Angolo(g1, p1, s1);

        System.out.print("Longitudine (gradi primi secondi, gradi negativi se il punto si trova a ovest del meridiano di Greenwich): ");
        double g2 = in.nextDouble();
        double p2 = in.nextDouble();
        double s2 = in.nextDouble();
        Angolo long1 = new Angolo(g2, p2, s2);

        PuntoGeografico punto1 = new PuntoGeografico(lat1, long1);

        System.out.println("Inserisci il secondo punto geografico:");
        System.out.print("Latitudine (gradi primi secondi, separati da spazi, gradi negativi se il punto si trova a sud dell'equatore): ");
        g1 = in.nextDouble();
        p1 = in.nextDouble();
        s1 = in.nextDouble();
        Angolo lat2 = new Angolo(g1, p1, s1);

        System.out.print("Longitudine (gradi primi secondi, gradi negativi se il punto si trova a ovest del meridiano di Greenwich): ");
        g2 = in.nextDouble();
        p2 = in.nextDouble();
        s2 = in.nextDouble();
        Angolo long2 = new Angolo(g2, p2, s2);

        PuntoGeografico punto2 = new PuntoGeografico(lat2, long2);

        int scelta;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mostra primo punto");
            System.out.println("2. Mostra secondo punto");
            System.out.println("3. Distanza tra i due punti");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println(punto1);
                    break;
                case 2:
                    System.out.println(punto2);
                    break;
                case 3:
                    System.out.println("Distanza: " + punto1.distanza(punto2) + " metri");
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        in.close();
    }
}
