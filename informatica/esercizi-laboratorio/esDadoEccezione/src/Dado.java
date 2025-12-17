public class Dado {
    private int facceDado;

    public Dado(){
        this.facceDado = 6;
    }

    public Dado(int N) throws ParametroNonValidoEccezione {
        if (N < 2 || N == 3) {
            throw new ParametroNonValidoEccezione("Il dado non può avere meno di 2 facce o esattamente 3 facce");
        } else {
            this.facceDado = N;
        }
    }

    public Dado(Dado dadoCopia) {
        this.facceDado = dadoCopia.facceDado;
    }

    public int getFacceDado() {
        return facceDado;
    }

    public int lancia(){
        return (int) (Math.random() * 10 % this.facceDado + 1);
    }

    @Override
    public String toString() {
        return "Facce del dado: " + this.facceDado;
    }
}