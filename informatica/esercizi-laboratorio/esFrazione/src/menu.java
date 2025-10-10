import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Frazione f1 = null;

        while (true) {
            System.out.println("\n--- MENU FRAZIONE ---");
            System.out.println("1. Inserisci frazione");
            System.out.println("2. Visualizza frazione");
            System.out.println("3. Valore decimale");
            System.out.println("4. Somma con un'altra frazione");
            System.out.println("5. Differenza con un'altra frazione");
            System.out.println("6. Prodotto con un'altra frazione");
            System.out.println("7. Quoziente con un'altra frazione");
            System.out.println("8. Confronta con un'altra frazione");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Numeratore: ");
                    int num = in.nextInt();
                    System.out.print("Denominatore: ");
                    int den = in.nextInt();
                    f1 = new Frazione(num, den);
                    System.out.println("Frazione creata: " + f1);
                    break;

                case 2:
                    if (f1 == null) {
                        System.out.println("Crea prima una frazione.");
                    } else {
                        System.out.println("Frazione: " + f1);
                    }
                    break;

                case 3:
                    if (f1 != null)
                        System.out.println("Valore decimale: " + f1.toDouble());
                    else
                        System.out.println("Crea prima una frazione.");
                    break;

                case 4:
                    if (f1 == null) {
                        System.out.println("Crea prima una frazione.");
                        break;
                    }
                    Frazione f2 = creaFrazioneDaInput(in);
                    System.out.println("Risultato somma: " + f1.somma(f2));
                    break;

                case 5:
                    if (f1 == null) {
                        System.out.println("Crea prima una frazione.");
                        break;
                    }
                    f2 = creaFrazioneDaInput(in);
                    System.out.println("Risultato differenza: " + f1.differenza(f2));
                    break;

                case 6:
                    if (f1 == null) {
                        System.out.println("Crea prima una frazione.");
                        break;
                    }
                    f2 = creaFrazioneDaInput(in);
                    System.out.println("Risultato prodotto: " + f1.prodotto(f2));
                    break;

                case 7:
                    if (f1 == null) {
                        System.out.println("Crea prima una frazione.");
                        break;
                    }
                    f2 = creaFrazioneDaInput(in);
                    System.out.println("Risultato quoziente: " + f1.quoziente(f2));
                    break;

                case 8:
                    if (f1 == null) {
                        System.out.println("Crea prima una frazione.");
                        break;
                    }
                    f2 = creaFrazioneDaInput(in);
                    System.out.println("Le frazioni sono uguali? " + f1.equals(f2));
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    in.close();
                    return;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    private static Frazione creaFrazioneDaInput(Scanner in) {
        System.out.print("Inserisci numeratore: ");
        int num = in.nextInt();
        System.out.print("Inserisci denominatore: ");
        int den = in.nextInt();
        return new Frazione(num, den);
    }
}
