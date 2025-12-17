import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        FileReader fr = null;
        try {
             fr = new FileReader("src/testo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("ERRORE: " + e);
            return;
        }
        BufferedReader br = new BufferedReader(fr);
        String riga;
        try {
            int sommaParole = 0;
            int sommaRighe = 0;
            int sommaCaratteri = 0;
            while ((riga= br.readLine()) != null) {
                sommaRighe++;
                String[] parole = riga.split(" ");
                for (String parola:parole){
                    sommaCaratteri+=parola.length();
                }
                sommaParole += parole.length;
            }
            System.out.println("PAROLE: " + sommaParole);
            System.out.println("RIGHE: " + sommaRighe);
            System.out.println("CARATTERI: " + sommaCaratteri);

        }
        catch (IOException e) {
            System.out.println("ERRORE " +  e );

        }

        try{
            br.close();
            fr.close();
        }
        catch (IOException e){
            System.out.println("ERRORE " + e);
        }

    }
}