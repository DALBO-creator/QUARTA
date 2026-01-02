import java.util.ArrayList;

public class MasterMind {
    private Sequenza sequenzaNascosta;
    public ArrayList<Sequenza> tentativi = new ArrayList<>();
    private ArrayList<Indizio> indizi = new ArrayList<>();
    private int maxTentativi;

    public MasterMind() {
        this.sequenzaNascosta = new Sequenza();
        this.maxTentativi = 10;
    }

    public MasterMind(Sequenza seq) {
        this.sequenzaNascosta = seq;
        this.maxTentativi = 10;
    }

    public MasterMind(Sequenza seq, int maxTentativi) {
        this.sequenzaNascosta = seq;
        this.maxTentativi = Math.max(maxTentativi, 10);
    }

    public void add(Sequenza tentativo) {
        if (tentativi.size() >= maxTentativi) return;
        tentativi.add(tentativo);
        indizi.add(sequenzaNascosta.confronta(tentativo));
    }

    public boolean vittoria() {
        if (tentativi.isEmpty()) return false;
        return tentativi.get(tentativi.size() - 1).equals(sequenzaNascosta);
    }

    public boolean terminato() {
        return vittoria() || tentativi.size() >= maxTentativi;
    }

    public Sequenza getSequenza(int index) {
        if (index < 0 || index >= tentativi.size()) return null;
        return tentativi.get(index);
    }

    public Sequenza getSequenzaNascosta() {
        return sequenzaNascosta;
    }

    public Indizio getIndizio(int index) {
        if (index < 0 || index >= indizi.size()) return null;
        return indizi.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = tentativi.size() - 1; i >= 0; i--) {
            sb.append((i+1)).append(" ")
                    .append(getIndizio(i).toString()).append(" ")
                    .append(getSequenza(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
