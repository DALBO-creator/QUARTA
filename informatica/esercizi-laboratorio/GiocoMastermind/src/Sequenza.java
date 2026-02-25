import java.util.Arrays;

public class Sequenza {
    private Colore[] colori = new Colore[4];

    public Sequenza() {
        for (int i = 0; i < 4; i++) {
            colori[i] = Colore.getRandom();
        }
    }

    public Sequenza(Colore c1, Colore c2, Colore c3, Colore c4) {
        colori[0] = c1;
        colori[1] = c2;
        colori[2] = c3;
        colori[3] = c4;
    }

    public boolean equals(Sequenza altra) {
        return Arrays.equals(this.colori, altra.colori);
    }

    public Indizio confronta(Sequenza tentativo) {
        boolean[] usataNascosta = new boolean[4];
        boolean[] usataTentativo = new boolean[4];
        int neri = 0;
        int bianchi = 0;

        for (int i = 0; i < 4; i++) {
            if (tentativo.colori[i] == this.colori[i]) {
                neri++;
                usataNascosta[i] = true;
                usataTentativo[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!usataTentativo[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!usataNascosta[j] && tentativo.colori[i] == this.colori[j]) {
                        bianchi++;
                        usataNascosta[j] = true;
                        break;
                    }
                }
            }
        }

        return new Indizio(bianchi, neri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Colore c : colori) {
            sb.append(c.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
