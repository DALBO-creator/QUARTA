import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        System.out.println("inserisci 2 interi compresi tra 1 mlrd e 2 mlrd");
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(a + "    " + b + "   " + (a+b) + "   " + (a-b)  + "   " + (a*b));
        System.out.println("il prodotto risulta diverso da quello che ci si aspetta poichè i bit non sono abbastanza, infatti una variabile int ha un limite di 32 bit");

    }
}
