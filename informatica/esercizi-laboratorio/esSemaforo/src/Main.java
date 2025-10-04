public class Main {
    public static void main(String[] args) {
        semaforo s = new semaforo();
        s.accendi();
        s.avanza();
        System.out.println(s.isAcceso());
        System.out.println(s.getColore());
        System.out.println(s.toString());
        s.toggle();
        System.out.println(s.toString());
    }
}