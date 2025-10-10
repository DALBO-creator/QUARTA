public class Main {
    public static void main(String[] args) {

        PuntoGeometrico p1 = new PuntoGeometrico(0, 0);
        PuntoGeometrico p2 = new PuntoGeometrico(4, 0);
        PuntoGeometrico p3 = new PuntoGeometrico(2, -1);
        PuntoGeometrico p4 = new PuntoGeometrico(2, 1);


        Segmento s1 = new Segmento(p1, p2);
        Segmento s2 = new Segmento(p3, p4);

        System.out.println("Segmento 1: " + s1);
        System.out.println("Segmento 2: " + s2);


        System.out.println("I segmenti si intersecano? " + s1.Interseca(s2));


        s1.ruotaOrigine(90);
        System.out.println("Segmento 1 ruotato attorno all'origine di 90°: " + s1);


        s2.ruotaEstremo(90, 1);
        System.out.println("Segmento 2 ruotato di 90° attorno all'estremo 1: " + s2);


        Segmento copia = new Segmento(s1);
        System.out.println("Copia del segmento 1: " + copia);
    }
}
