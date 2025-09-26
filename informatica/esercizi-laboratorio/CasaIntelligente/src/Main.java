import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LampadinaIntelligente l = new LampadinaIntelligente(-50);
        System.out.println("inserisci nome lampadina: ");
        String nome = in.nextLine();
        l.setNome(nome);
        System.out.println("accesa o spenta?");
        String risposta = in.nextLine();
        if (risposta.equals("accesa")){
            l.setAcceso(true);
        }
        else{
            l.setAcceso(false);

        }
        System.out.println("inserisci colore lampadina: ");
        String colore = in.nextLine();
        l.setColore(colore);
        System.out.println(l.toString());











    }
}