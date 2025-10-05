import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Incrocio incrocio = new Incrocio();
        int scelta;

        do {
            System.out.println("\n--- MENU INCROCIO ---");
            System.out.println("1. Accendi incrocio");
            System.out.println("2. Spegni incrocio");
            System.out.println("3. Avanza un semaforo");
            System.out.println("4. Mostra stato incrocio");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    incrocio.accendi();
                    System.out.println("Incrocio acceso.");
                    break;

                case 2:
                    incrocio.spegni();
                    System.out.println("Incrocio spento.");
                    break;

                case 3:
                    if (!incrocio.isAcceso()) {
                        System.out.println("L'incrocio è spento!");
                        break;
                    }
                    System.out.print("Quale semaforo vuoi far avanzare (N/S/E/O): ");
                    char p = in.next().toUpperCase().charAt(0);
                    incrocio.avanza(p);
                    break;

                case 4:
                    System.out.println(incrocio.toString());
                    break;

                case 0:
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        } while (scelta != 0);

    }
}
