public class Main {
    public static void main(String[] args) {
        String prefisso = "ABC";

        GeneratoreAutoIncrementale g = new GeneratoreAutoIncrementale(prefisso, 4);
        System.out.println(g.genera());
        System.out.println(g.genera());
        System.out.println(g.genera());
        System.out.println(g.toString());





    }
}