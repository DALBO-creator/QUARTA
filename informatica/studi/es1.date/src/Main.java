import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        //. Creare un programma che, prendendo la data odierna, indichi che data sarà tra un giorno, tra
        //un mese e tra un anno.

        LocalDate oggi = LocalDate.now();
        System.out.println(oggi.plusDays(1));
        System.out.println(oggi.plusMonths(1));
        System.out.println(oggi.plusYears(1));


    }
}