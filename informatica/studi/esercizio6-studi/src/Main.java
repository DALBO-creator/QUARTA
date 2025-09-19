import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        System.out.println("inserisci un intero");
        a = in.nextInt();
        System.out.println(a * 1000 + "   " + (a/10) + "   " + (a%3));
    }
}
