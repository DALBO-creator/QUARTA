import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("scegi 2 numeri interi, positivi");
        int N = in.nextInt();
        int M = in.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print('x');
            }
            System.out.println();
        }
    }

}

