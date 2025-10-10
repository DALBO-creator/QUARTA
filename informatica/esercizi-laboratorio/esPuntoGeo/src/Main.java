public class Main {
    public static void main(String[] args) {
        // Test costruttori
        PuntoGeometrico p1 = new PuntoGeometrico(3, 4);
        PuntoGeometrico p2 = new PuntoGeometrico(6, 8);
        PuntoGeometrico p3 = new PuntoGeometrico(p1); // copia di p1

        System.out.println("Punto p1: " + p1);
        System.out.println("Punto p2: " + p2);
        System.out.println("Punto p3 (copia di p1): " + p3);

        // Test distanza (tra p1 e p2)
        double distanza = p1.Distanza(p1, p2);
        System.out.println("Distanza tra p1 e p2: " + distanza);

        // Test punto medio (tra p1 e p2)
        PuntoGeometrico medio = p1.PuntoMedio(p2);
        System.out.println("Punto medio tra p1 e p2: " + medio);

        // Test rotazione
        System.out.println("p1 prima della rotazione: " + p1);
        p1.ruota(90);
        System.out.println("p1 dopo rotazione di 90°: " + p1);
    }
}
