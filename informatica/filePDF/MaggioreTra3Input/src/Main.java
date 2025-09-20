import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        int c;
        System.out.println("inserisci 3 interi");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        if (a>b && a > c){
            System.out.println(a);
        }
        else if(b>a && b>c){
            System.out.println(b);
        }
        else {
            System.out.println(c);
        }
    }
}
