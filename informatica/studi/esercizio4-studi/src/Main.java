import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        float b;
        double c;
        System.out.println("inserisci un intero, un float e un double");
        a = in.nextInt();
        b = in.nextFloat();
        c = in.nextDouble();
        System.out.println(c + "    " + b + "     " + a );
        }
    }
