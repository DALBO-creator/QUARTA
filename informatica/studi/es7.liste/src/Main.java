import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int N = 1_000_000;
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        List<Double> arrayList = new ArrayList<>();
        List<Double> linkedList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            double numero = rand.nextDouble() * 1000000;
            arrayList.add(numero);
            linkedList.add(numero);
        }

        System.out.print("Inserisci posizione p per il prodotto di tre elementi: ");
        int p = in.nextInt();

        System.out.println("con un ArrayList");
        double sommaA = 0;
        double maxA = Double.NEGATIVE_INFINITY;
        double minA = Double.POSITIVE_INFINITY;
        for (double num : arrayList) {
            sommaA += num;
            if (num > maxA) maxA = num;
            if (num < minA) minA = num;
        }
        double prodottoA = 1;
        if (p >= 0 && p + 2 < arrayList.size()) {
            prodottoA = arrayList.get(p) * arrayList.get(p + 1) * arrayList.get(p + 2);
        }
        System.out.println("Somma: " + sommaA);
        System.out.println("Massimo: " + maxA);
        System.out.println("Minimo: " + minA);
        System.out.println("Prodotto tre elementi da p: " + prodottoA);

        System.out.println("con una LinkedList");
        double sommaL = 0;
        double maxL = Double.NEGATIVE_INFINITY;
        double minL = Double.POSITIVE_INFINITY;
        for (double num : linkedList) {
            sommaL += num;
            if (num > maxL) maxL = num;
            if (num < minL) minL = num;
        }
        double prodottoL = 1;
        if (p >= 0 && p + 2 < linkedList.size()) {
            prodottoL = linkedList.get(p) * linkedList.get(p + 1) * linkedList.get(p + 2);
        }
        System.out.println("Somma: " + sommaL);
        System.out.println("Massimo: " + maxL);
        System.out.println("Minimo: " + minL);
        System.out.println("Prodotto tre elementi da p: " + prodottoL);

        in.close();
    }
}


//Somma, massimo e minimo hanno tempi simili tra ArrayList e LinkedList.
//Prodotto da posizione p è molto più veloce in ArrayList rispetto a LinkedList, perchè la LinkedList deve scorrere tutti gli elemnti fino alla posizione p
