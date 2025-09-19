import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a;
        System.out.println("inserisci un double");
        a = in.nextDouble();
        System.out.println(a/(1000*1000000000));
    }
}
