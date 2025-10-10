import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PuntoGeometrico punto = null;
        boolean esci = false;

        while (!esci) {
            System.out.println("\n--- MENU PUNTO GEOMETRICO ---");
            System.out.println("1. Crea un nuovo punto");
            System.out.println("2. Visualizza il punto");
            System.out.println("3. Ruota il punto");
            System.out.println("4. Calcola distanza da un altro punto");
            System.out.println("5. Calcola punto medio con un altro punto");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci x: ");
                    double x = input.nextDouble();
                    System.out.print("Inserisci y: ");
                    double y = input.nextDouble();
                    punto = new PuntoGeometrico(x, y);
                    System.out.println("Punto creato: " + punto);
                    break;

                case 2:
                    if (punto != null)
                        System.out.println("Punto attuale: " + punto);
                    else
                        System.out.println("Nessun punto creato");
                    break;

                case 3:
                    if (punto != null) {
                        System.out.print("Inserisci angolo di rotazione (in gradi): ");
                        double angolo = input.nextDouble();
                        punto.ruota(angolo);
                        System.out.println("Punto dopo rotazione: " + punto);
                    } else {
                        System.out.println("Crea prima un punto");
                    }
                    break;

                case 4:
                    if (punto != null) {
                        System.out.print("Inserisci le coordinate del secondo punto (x y): ");
                        double x2 = input.nextDouble();
                        double y2 = input.nextDouble();
                        PuntoGeometrico altro = new PuntoGeometrico(x2, y2);
                        double d = punto.Distanza(punto, altro);
                        System.out.println("Distanza: " + d);
                    } else {
                        System.out.println("Crea prima un punto");
                    }
                    break;

                case 5:
                    if (punto != null) {
                        System.out.print("Inserisci le coordinate del secondo punto (x y): ");
                        double xm = input.nextDouble();
                        double ym = input.nextDouble();
                        PuntoGeometrico pmedio = punto.PuntoMedio(new PuntoGeometrico(xm, ym));
                        System.out.println("Punto medio: " + pmedio);
                    } else {
                        System.out.println("Crea prima un punto");
                    }
                    break;

                case 6:
                    esci = true;
                    System.out.println("Programma terminato");
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }
}
