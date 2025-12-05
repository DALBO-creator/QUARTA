import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        FileReader fr = null;
        boolean err;
        String nomeFile = null;
        do {
            System.out.println("inserisci nome file");
            nomeFile = in.nextLine();
            try {
                fr = new FileReader(nomeFile);
                fr.close();
                err = false;
            } catch (FileNotFoundException e) {
                System.out.println("ERRORE: " + e);
                err=true;

            }
        } while (err);

        System.out.println("inserisci parola da sostituire: ");
        String vecchia = in.nextLine();
        System.out.println("inserisci sostituzione: ");
        String nuova = in.nextLine();

        try {
                 fr = new FileReader(nomeFile);
                 BufferedReader br = new BufferedReader(fr);;
                 String riga;
                 ArrayList<String> testo = new ArrayList<>();
                 while ((riga = br.readLine())!=null){
                     String RigaMod = riga.replaceAll(vecchia, nuova);
                      testo.add(RigaMod);
                 }
                 for (int i = 0; i < testo.size() ; i++) {
                 System.out.println(testo.get(i));
                 }
            }
        catch (IOException e) {
            System.out.println("ERRORE: " + e);
        }
    }
}