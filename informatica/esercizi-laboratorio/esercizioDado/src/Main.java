import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("numero di facce dei dadi 3 e 4?");
        int facceDado = in.nextInt();


        Dado dado1 = new Dado();
        Dado dado2 = new Dado(dado1);

        Dado dado3 = new Dado(facceDado);
        Dado dado4 = new Dado(dado3);




        System.out.println("Numero uscito dal dado4: " + dado4.Lancia());
        System.out.println(dado4);


    }
}