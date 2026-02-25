public class Indizio {
    private int bianchi;
    private int neri;

    public Indizio(int bianchi, int neri) {
        if (bianchi + neri > 4) {
            throw new IllegalArgumentException("La somma dei piolini non può superare 4");
        }
        this.bianchi = bianchi;
        this.neri = neri;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bianchi; i++) sb.append("b ");
        for (int i = 0; i < neri; i++) sb.append("n ");
        return sb.toString().trim();
    }
}
