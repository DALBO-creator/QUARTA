import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        float b;
        System.out.println("inserisci un intero e un float");
        a = in.nextInt();
        b = in.nextFloat();
        System.out.println(a * b);
    }
}
