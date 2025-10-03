public class GeneratoreAutoIncrementale {
    private String prefisso;
    private int numeroCifre;
    private int counter;

    public GeneratoreAutoIncrementale(String prefisso, int numeroCifre) {
        this.prefisso = prefisso;
        this.numeroCifre = numeroCifre;
        this.counter = 0;
    }

    public String genera() {
        if (counter >= Math.pow(10, numeroCifre) - 1) {
            return "Codici esauriti";
        }
        counter++;
        String num = "" + counter;
        while (num.length() < numeroCifre) {
            num = "0" + num;
        }
        return prefisso + num;
    }


    @Override
    public String toString() {
        return "Prefisso: " + prefisso + " ultimo valore generato: " + counter;
    }
}
