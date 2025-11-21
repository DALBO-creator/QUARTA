import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Casa casa = new Casa("Casa Domotica", "assets/piantinaCasa.jpg");

        // Carica le stanze dal file
        try (BufferedReader br = new BufferedReader(new FileReader("assets/CoordinateStanze.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                casa.aggiungiStanza(new Stanza(nome, x, y));
            }
        } catch (IOException e) {
            System.out.println("Errore nel file: " + e);
        }

        Scanner in = new Scanner(System.in);
        int scelta = -1;

        while (scelta != 0) {
            System.out.println("\n--- MENU CASA DOMOTICA ---");
            System.out.println("1. Accendi una stanza");
            System.out.println("2. Spegni una stanza");
            System.out.println("3. Cambia colore ad una stanza");
            System.out.println("4. Aumenta luminosità");
            System.out.println("5. Diminuisci luminosità");
            System.out.println("6. Accendi tutte");
            System.out.println("7. Spegni tutte");
            System.out.println("8. Mostra stato casa");
            System.out.println("9. Aggiungi lampadina a una stanza");
            System.out.println("10. Rimuovi lampadina da una stanza");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();
            in.nextLine(); // pulizia del buffer di lettura

            switch (scelta) {
                case 1:
                    System.out.print("Nome stanza: ");
                    String nomeAccendi = in.nextLine();
                    Stanza s1 = casa.cercaStanza(nomeAccendi);
                    if (s1 != null) s1.accendi();
                    else System.out.println("Stanza non trovata.");
                    break;
                case 2:
                    System.out.print("Nome stanza: ");
                    String nomeSpegni = in.nextLine();
                    Stanza s2 = casa.cercaStanza(nomeSpegni);
                    if (s2 != null) s2.spegni();
                    else System.out.println("Stanza non trovata.");
                    break;
                case 3:
                    System.out.print("Nome stanza: ");
                    String nomeCambia = in.nextLine();
                    Stanza s3 = casa.cercaStanza(nomeCambia);
                    if (s3 != null) s3.cambiaColore();
                    else System.out.println("Stanza non trovata.");
                    break;
                case 4:
                    System.out.print("Nome stanza: ");
                    String nomeAum = in.nextLine();
                    Stanza s4 = casa.cercaStanza(nomeAum);
                    if (s4 != null) s4.aumentaLuminosita();
                    else System.out.println("Stanza non trovata.");
                    break;
                case 5:
                    System.out.print("Nome stanza: ");
                    String nomeDim = in.nextLine();
                    Stanza s5 = casa.cercaStanza(nomeDim);
                    if (s5 != null) s5.diminuisciLuminosita();
                    else System.out.println("Stanza non trovata.");
                    break;
                case 6:
                    casa.accendiTutte();
                    break;
                case 7:
                    casa.spegniTutte();
                    break;
                case 8:
                    System.out.println(casa);
                    break;
                case 9:
                    System.out.print("Nome stanza: ");
                    String nomeAdd = in.nextLine();
                    Stanza sAdd = casa.cercaStanza(nomeAdd);
                    if (sAdd != null) {
                        sAdd.aggiungiLampadina();
                        System.out.println("Lampadina aggiunta.");
                    } else {
                        System.out.println("Stanza non trovata.");
                    }
                    break;
                case 10:
                    System.out.print("Nome stanza: ");
                    String nomeRem = in.nextLine();
                    Stanza sRem = casa.cercaStanza(nomeRem);
                    if (sRem != null) { //se è null la stanza non è stata trovata (nome stanza != nome passato come parametro
                        System.out.println("Lampadine in " + nomeRem +": " + sRem.getLampadine().size());
                        System.out.print("Indice lampadina da rimuovere: " );
                        int i = in.nextInt();
                        in.nextLine();

                        sRem.rimuoviLampadina(i-1);
                    } else {
                        System.out.println("Stanza non trovata.");
                    }
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }

        in.close();
    }
}