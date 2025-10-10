public class Main {
    public static void main(String[] args) {
        Frazione f1 = new Frazione(1, 2);
        Frazione f2 = new Frazione(3, 4);

        System.out.println("Frazione 1: " + f1); // 1/2
        System.out.println("Frazione 2: " + f2); // 3/4

        System.out.println("Somma: " + f1.somma(f2));         // 5/4
        System.out.println("Differenza: " + f1.differenza(f2)); // -1/4
        System.out.println("Prodotto: " + f1.prodotto(f2));     // 3/8
        System.out.println("Quoziente: " + f1.quoziente(f2));   // 2/3

        System.out.println("Valore double f1: " + f1.toDouble()); // 0.5

        Frazione f3 = new Frazione(2, 4);
        System.out.println("f1.equals(f3)? " + f1.equals(f3)); // true
    }
}
