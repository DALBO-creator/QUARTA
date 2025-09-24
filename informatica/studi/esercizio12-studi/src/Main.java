import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("scegi un numero e un carattere");
        int N = in.nextInt();
        in.nextLine();
        String c = in.nextLine();
        for (int i = 1; i <= N; i++) {
            System.out.print(c);
            if (i%5==0){
                System.out.println();
            }


        }

    }
}
