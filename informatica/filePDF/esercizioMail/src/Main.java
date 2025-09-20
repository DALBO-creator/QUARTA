import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("inserisci nome, cognome e mail provider");
        String n1 = in.nextLine();
        String c1 = in.nextLine();
        String m1 = in.nextLine();
        String mail1 = n1 + '.' + c1+ '@' + m1 + ".com";
        System.out.println("mail: " + mail1 );
        System.out.println("inserisci ancora nome, cognome e mail provider");
        String n2 = in.nextLine();
        String c2 = in.nextLine();
        String m2  = in.nextLine();
        String mail2 = n2 + '.' + c2+ '@' + m2 + ".com";
        System.out.println("mail: " + mail2 );
        if (mail1.equals(mail2)){
            System.out.println("le mail sono uguali");
        }
        else {
            System.out.println("le mail sono diverse");
        }




    }
    }
