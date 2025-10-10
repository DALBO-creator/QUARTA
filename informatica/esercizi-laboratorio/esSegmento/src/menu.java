import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Segmento segmento = null;

        while (true) {
            System.out.println("\n--- MENU SEGMENTO ---");
            System.out.println("1. Crea segmento");
            System.out.println("2. Visualizza segmento");
            System.out.println("3. Ruota attorno all'origine");
            System.out.println("4. Ruota attorno a un estremo");
            System.out.println("5. Verifica intersezione con un altro segmento");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci x1: ");
                    double x1 = in.nextDouble();
                    System.out.print("Inserisci y1: ");
                    double y1 = in.nextDouble();
                    System.out.print("Inserisci x2: ");
                    double x2 = in.nextDouble();
                    System.out.print("Inserisci y2: ");
                    double y2 = in.nextDouble();

                    segmento = new Segmento(new PuntoGeometrico(x1, y1), new PuntoGeometrico(x2, y2));
                    System.out.println("Segmento creato ");
                    break;

                case 2:
                    if (segmento == null) {
                        System.out.println("Crea prima un segmento");
                    } else {
                        System.out.println("Segmento: " + segmento);
                    }
                    break;

                case 3:
                    if (segmento == null) {
                        System.out.println("Crea prima un segmento");
                    } else {
                        System.out.print("Inserisci angolo in gradi: ");
                        double angoloOrigine = in.nextDouble();
                        segmento.ruotaOrigine(angoloOrigine);
                        System.out.println("Segmento ruotato attorno all'origine.");
                    }
                    break;

                case 4:
                    if (segmento == null) {
                        System.out.println("Crea prima un segmento.");
                    } else {
                        System.out.print("Inserisci angolo in gradi: ");
                        double angoloEstremo = in.nextDouble();
                        System.out.print("Quale estremo (1 o 2)? ");
                        int estremo = in.nextInt();
                        segmento.ruotaEstremo(angoloEstremo, estremo);
                        System.out.println("Segmento ruotato attorno all'estremo " + estremo);
                    }
                    break;

                case 5:
                    if (segmento == null) {
                        System.out.println("Crea prima un segmento.");
                    } else {
                        System.out.println("Inserisci un secondo segmento per verificare intersezione:");
                        System.out.print("x1: ");
                        double sx1 = in.nextDouble();
                        System.out.print("y1: ");
                        double sy1 = in.nextDouble();
                        System.out.print("x2: ");
                        double sx2 = in.nextDouble();
                        System.out.print("y2: ");
                        double sy2 = in.nextDouble();

                        Segmento altro = new Segmento(new PuntoGeometrico(sx1, sy1), new PuntoGeometrico(sx2, sy2));
                        boolean interseca = segmento.Interseca(altro);
                        System.out.println("I segmenti si intersecano? " + interseca);
                    }
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    return;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}
