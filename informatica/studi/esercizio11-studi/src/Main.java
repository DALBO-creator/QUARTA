import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        System.out.println("inserisci 2 double compresi tra 1 mlrd e 2 mlrd");
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(a + "    " + b + "   " + (a+b) + "   " + (a-b)  + "   " + (a*b));
        System.out.println("con i doule non ci sono problemi, poichè hanno a disposizione 64bit");

    }
}
