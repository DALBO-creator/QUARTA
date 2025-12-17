import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Casa casa = new Casa("Casa Domotica", "assets/piantinaCasa.jpg");

        // Caricamento delle stanze dal file
        try (BufferedReader br = new BufferedReader(new FileReader("assets/CoordinateStanze.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String nome = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                int maxLampadine = Integer.parseInt(parts[3]);
                casa.aggiungiStanza(new Stanza(nome, x, y, maxLampadine));
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
            System.out.println("4. Aumenta luminosità stanza");
            System.out.println("5. Diminuisci luminosità stanza");
            System.out.println("6. Accendi tutte");
            System.out.println("7. Spegni tutte");
            System.out.println("8. Mostra stato casa");
            System.out.println("9. Aggiungi lampadina a una stanza");
            System.out.println("10. Rimuovi lampadina da una stanza");
            System.out.println("11. Salva stato casa");
            System.out.println("12. Carica casa salvata");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            try {
                scelta = in.nextInt();
                in.nextLine(); // pulizia buffer
            } catch (InputMismatchException e) {
                System.out.println("Input non valido, inserisci un numero");
                in.nextLine(); // scartiamo l'input errato
                scelta = -1;   // forziamo il ciclo a continuare
                continue;
            }

            switch (scelta) {
                case 1:
                    System.out.print("Nome stanza: ");
                    String nomeAccendi = in.nextLine();
                    Stanza s1 = casa.cercaStanza(nomeAccendi);
                    if (s1 != null) s1.accendi();
                    else System.out.println("Stanza non trovata");
                    break;

                case 2:
                    System.out.print("Nome stanza: ");
                    String nomeSpegni = in.nextLine();
                    Stanza s2 = casa.cercaStanza(nomeSpegni);
                    if (s2 != null) s2.spegni();
                    else System.out.println("Stanza non trovata");
                    break;

                case 3:
                    System.out.print("Nome stanza: ");
                    String nomeCambia = in.nextLine();
                    Stanza s3 = casa.cercaStanza(nomeCambia);
                    if (s3 != null) s3.cambiaColore();
                    else System.out.println("Stanza non trovata");
                    break;

                case 4:
                    System.out.print("Nome stanza: ");
                    String nomeAum = in.nextLine();
                    Stanza s4 = casa.cercaStanza(nomeAum);
                    if (s4 != null) s4.aumentaLuminosita();
                    else System.out.println("Stanza non trovata");
                    break;

                case 5:
                    System.out.print("Nome stanza: ");
                    String nomeDim = in.nextLine();
                    Stanza s5 = casa.cercaStanza(nomeDim);
                    if (s5 != null) s5.diminuisciLuminosita();
                    else System.out.println("Stanza non trovata");
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
                        if (sAdd.aggiungiLampadina()) {
                            System.out.println("Lampadina aggiunta.");
                        }
                        // se ritorna false, il messaggio è già stato stampato dentro aggiungiLampadina()
                    } else {
                        System.out.println("Stanza non trovata.");
                    }
                    break;

                case 10:
                    System.out.print("Nome stanza: ");
                    String nomeRem = in.nextLine();
                    Stanza sRem = casa.cercaStanza(nomeRem);
                    if (sRem != null) {
                        int numLampadine = sRem.getLampadine().size();
                        if (numLampadine == 0) {
                            System.out.println("Nessuna lampadina da rimuovere");
                            break;
                        }
                        System.out.println("Lampadine in " + nomeRem + ": " + numLampadine);
                        System.out.print("Indice lampadina da rimuovere (1-" + numLampadine + "): ");
                        try {
                            int i = in.nextInt();
                            in.nextLine();
                            if (i >= 1 && i <= numLampadine) {
                                sRem.rimuoviLampadina(i - 1);
                                System.out.println("Lampadina rimossa");
                            } else {
                                System.out.println("Indice non valido");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Inserisci un numero valido");
                            in.nextLine();
                        }
                    } else {
                        System.out.println("Stanza non trovata");
                    }
                    break;

                case 11:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("casa.dat"))) {
                        oos.writeObject(casa);
                        System.out.println("Stato della casa salvato con successo!");
                    } catch (IOException e) {
                        System.out.println("Errore nel salvataggio: " + e);
                    }
                    break;

                case 12:
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("casa.dat"))) {
                        casa = (Casa) ois.readObject();
                        System.out.println("Stato della casa caricato con successo!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Errore nel caricamento: " + e);
                    }
                    break;

                case 0:
                    System.out.println("Uscita dal programma..");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }
        }

        in.close();
    }
}
