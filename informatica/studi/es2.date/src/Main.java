import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //2. Creare un programma che, prendendo in input tre interi, che rappresentano rispettivamente
        //giorno, mese e anno di una data a scelta, crei un oggetto di tipo LocalDate utilizzando il
        //metodo of e indichi che data sarà tra un giorno, tra un mese e tra un anno a partire da quella
        //data.

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();


        LocalDate giorno = LocalDate.of(c,b,a);
        System.out.println(giorno.plusDays(1));
        System.out.println(giorno.plusMonths(1));
        System.out.println(giorno.plusYears(1));



    }
}