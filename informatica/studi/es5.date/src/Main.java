import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 5. Creare un programma che chieda all’utente di inserire tre date valide,
        // memorizzandole in un array. Successivamente, tramite un menù di scelta,
        // chieda all’utente di selezionare un giorno (1), un mese (2) o un anno (3)
        // e mostri le date che corrispondono al valore scelto.

        Scanner in = new Scanner(System.in);
        LocalDate[] date = new LocalDate[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Inserisci giorno, mese e anno della data " + (i + 1) + ": ");
            int giorno = in.nextInt();
            int mese = in.nextInt();
            int anno = in.nextInt();

            LocalDate d = LocalDate.of(anno, mese, giorno);
            date[i] = d;
        }

        int scelta;
        do {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1) Giorno");
            System.out.println("2) Mese");
            System.out.println("3) Anno");
            System.out.println("0) Esci");
            scelta = in.nextInt();

            switch (scelta) {
                case 1: {
                    System.out.print("Inserisci il giorno da cercare: ");
                    int g = in.nextInt();
                    boolean trovata = false;
                    for (LocalDate d : date) {
                        if (d.getDayOfMonth() == g) {
                            System.out.println(d);
                            trovata = true;
                        }
                    }
                    if (!trovata) System.out.println("Nessuna data con giorno " + g);
                }

                case 2: {
                    System.out.print("Inserisci il mese da cercare: ");
                    int m = in.nextInt();
                    boolean trovata = false;
                    for (LocalDate d : date) {
                        if (d.getMonthValue() == m) {
                            System.out.println(d);
                            trovata = true;
                        }
                    }
                    if (!trovata) System.out.println("Nessuna data con mese " + m);
                }

                case 3: {
                    System.out.print("Inserisci l'anno da cercare: ");
                    int a = in.nextInt();
                    boolean trovata = false;
                    for (LocalDate d : date) {
                        if (d.getYear() == a) {
                            System.out.println(d);
                            trovata = true;
                        }
                    }
                    if (!trovata) System.out.println("Nessuna data con anno " + a);
                }

                case 0: System.out.println("Uscita dal programma");
                default: System.out.println("Scelta non valida");
            }

        } while (scelta != 0);
    }
}
